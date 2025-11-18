package co.edu.uniquindio.poo.nexawallet.controllers;

import co.edu.uniquindio.poo.nexawallet.NexaWAplication;
import co.edu.uniquindio.poo.nexawallet.clases.Cliente;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TransferenciaProgramadaControllerTest {

    private TransferenciaProgramadaController controller;
    private Cliente clienteActual;
    private Cliente clienteDestino;

    @BeforeEach
    void setUp() {
        controller = new TransferenciaProgramadaController();

        controller.TxtCelular = new TextField();
        controller.TxtMonto = new TextField();
        controller.DateFechaDeEnvio = new DatePicker();

    }

    @Test
    void buscarCliente() {
        controller.TxtCelular.setText("200");

        assertTrue(controller.buscarCliente().isPresent());
        assertEquals(clienteDestino, controller.buscarCliente().get());

        controller.TxtCelular.setText("9999");

        assertFalse(controller.buscarCliente().isPresent());
    }

    @Test
    void onEnviar() {
        controller.TxtCelular.setText("200");
        controller.TxtMonto.setText("10000");
        controller.DateFechaDeEnvio.setValue(LocalDate.now().plusDays(1));

        assertDoesNotThrow(() -> controller.onEnviar(null));

        assertEquals(50000, clienteActual.getSaldo());
        assertEquals(20000, clienteDestino.getSaldo());
    }
}
