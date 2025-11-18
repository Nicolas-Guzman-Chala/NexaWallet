package co.edu.uniquindio.poo.nexawallet.controllers;
import co.edu.uniquindio.poo.nexawallet.NexaWAplication;
import co.edu.uniquindio.poo.nexawallet.clases.Cliente;
import co.edu.uniquindio.poo.nexawallet.clases.ClienteRegistro;
import co.edu.uniquindio.poo.nexawallet.clases.TipoRango;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;
class DepositarControllerTest {

    private DepositarController controller;
    private Cliente cliente;

    @BeforeEach
    void setUp() {
        controller = new DepositarController();
        ClienteRegistro c = new ClienteRegistro( "nico", "@", "123456");
        cliente = new Cliente("Luisa", "HER","123", "0", "@", 0,0, c, 0, 0, TipoRango.BRONCE );
        NexaWAplication.setClienteActual(cliente);

        controller.TxtMonto = new javafx.scene.control.TextField();
    }
    @Test
    void testDepositarSumaSaldo() {
        cliente.setSaldo(500);
        controller.TxtMonto.setText("200");

        controller.onDepositar(null);

        assertEquals(700, cliente.getSaldo());
    }
    @Test
    void testDepositarMenosDe100NoDaPuntos() {
        cliente.setPuntos(0);
        controller.TxtMonto.setText("50");

        controller.onDepositar(null);

        assertEquals(0, cliente.getPuntos());
    }
 @Test
    void testDepositar100NormalDa1Punto() {
        cliente.setPuntos(0);
        cliente.setTipoRango(TipoRango.BRONCE);
        controller.TxtMonto.setText("100");

        controller.onDepositar(null);

        assertEquals(1, cliente.getPuntos());
    }
 @Test
    void testDepositar100OroDa2Puntos() {
        cliente.setPuntos(0);
        cliente.setTipoRango(TipoRango.ORO);
        controller.TxtMonto.setText("100");

        controller.onDepositar(null);

        assertEquals(2, cliente.getPuntos());
    }
}