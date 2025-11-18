package co.edu.uniquindio.poo.nexawallet.controllers;

import co.edu.uniquindio.poo.nexawallet.NexaWAplication;
import co.edu.uniquindio.poo.nexawallet.clases.Cliente;
import co.edu.uniquindio.poo.nexawallet.clases.ClienteRegistro;
import co.edu.uniquindio.poo.nexawallet.clases.TipoRango;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RetirarControllerTest {

    private RetirarController controller;

    @BeforeEach
    void setUp() {
        controller = new RetirarController();

        controller.TxtMonto = new javafx.scene.control.TextField();

        ClienteRegistro reg = new ClienteRegistro("Juan", "juan@test.com", "123456");

        Cliente cliente = new Cliente(
                "Juan",
                "Pérez",
                "123",
                "3001112233",
                "juan@test.com",
                500, // saldo
                0,   // puntos
                reg,
                0,
                0,
                TipoRango.BRONCE
        );

        NexaWAplication.setClienteActual(cliente);
    }

    @Test
    void validarOro_CuandoNoEsOro() {
        NexaWAplication.getClienteActual().setTipoRango(TipoRango.BRONCE);

        assertFalse(controller.validarOro());
    }

    @Test
    void onRetirar_RestaSaldoCorrectamente() {

        controller.TxtMonto.setText("100");

        assertDoesNotThrow(() -> controller.onRetirar(null));

        assertEquals(400, NexaWAplication.getClienteActual().getSaldo());
    }

    @Test
    void onRetirar_SuperaSaldo_LanzaExcepcion() {

        controller.TxtMonto.setText("99999");

        assertThrows(IllegalArgumentException.class, () -> controller.onRetirar(null));
    }

    @Test
    void onRetirar_SumaPuntosEnBronce() {

        controller.TxtMonto.setText("200");

        controller.onRetirar(null);

        assertEquals(4, NexaWAplication.getClienteActual().getPuntos());
    }

    @Test
    void onRetirar_SumaPuntosEnOro() {

        NexaWAplication.getClienteActual().setTipoRango(TipoRango.ORO);

        controller.TxtMonto.setText("200");

        controller.onRetirar(null);

        assertEquals(8, NexaWAplication.getClienteActual().getPuntos());
    }

}
