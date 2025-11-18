package co.edu.uniquindio.poo.nexawallet.controllers;

import co.edu.uniquindio.poo.nexawallet.clases.ClienteRegistro;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegistroControllerTest {

    private RegistroController controller;

    @BeforeEach
    void setUp() {
        controller = new RegistroController();

        controller.TxtNombre = new TextField();
        controller.TxtEmail = new TextField();
        controller.TxtContrasena = new PasswordField();

        RegistroController.getListaClientesRegistro().clear();
    }

    @Test
    void onAgregarCliente() {

        controller.TxtNombre.setText("Juan Perez");
        controller.TxtEmail.setText("juan@test.com");
        controller.TxtContrasena.setText("12345678");

        assertDoesNotThrow(() -> controller.onAgregarCliente(null));

        assertEquals(1, RegistroController.getListaClientesRegistro().size());

        ClienteRegistro registrado = RegistroController.getListaClientesRegistro().get(0);

        assertEquals("Juan Perez", registrado.getNombre());
        assertEquals("juan@test.com", registrado.getCorreo());
        assertEquals("12345678", registrado.getContrasena());
    }
}
