package co.edu.uniquindio.poo.nexawallet.controllers;

import co.edu.uniquindio.poo.nexawallet.NexaWAplication;
import co.edu.uniquindio.poo.nexawallet.clases.Cliente;
import co.edu.uniquindio.poo.nexawallet.clases.ClienteRegistro;
import co.edu.uniquindio.poo.nexawallet.clases.TipoRango;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransferenciaControllerTest {

    TransferenciaController controller;
    Cliente emisor;
    Cliente receptor;

    @BeforeEach
    void setUp() {

        NexaWAplication.getListaClientes().clear();
        NexaWAplication.getListaClienteRegistro().clear();

        emisor = new Cliente("Juan", "Perez", "1", "3001112222", "a@a.com",
                500, 0, new ClienteRegistro("Juan","a@a.com","123"), 0, 100, TipoRango.BRONCE);

        receptor = new Cliente("Luis", "Gomez", "2", "3013334444", "b@b.com",
                100, 0, new ClienteRegistro("Luis","b@b.com","456"), 0, 100, TipoRango.BRONCE);

        NexaWAplication.getListaClientes().add(emisor);
        NexaWAplication.getListaClientes().add(receptor);

        NexaWAplication.setClienteActual(emisor);

        controller = new TransferenciaController();

        // Mock de los TextField JavaFX
        controller.InputMonto = new TextField();
        controller.InputCelular = new TextField();
    }

    @Test
    void onEnviar() {

        controller.InputMonto.setText("200");
        controller.InputCelular.setText("3013334444");

        assertDoesNotThrow(() -> controller.onEnviar(new ActionEvent()));

        assertEquals(300, receptor.getSaldo(), 0.01);

        assertEquals(300, emisor.getSaldo(), 0.01);

        assertEquals(6, emisor.getPuntos());

        assertEquals(1, emisor.getHistorialTransaccion().size());
    }
}
