package co.edu.uniquindio.poo.nexawallet.controllers;

import co.edu.uniquindio.poo.nexawallet.clases.ClienteRegistro;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class InicioSesionControllerTest {

    private InicioSesionController controller;

    @BeforeEach
    void setUp() {
        controller = new InicioSesionController();

        // Inicializamos manualmente los TextField del controlador
        controller.TxtEmail = new TextField();
        controller.TxtContrasena = new PasswordField();

        RegistroController.getListaClientesRegistro().clear();
        RegistroController.getListaClientesRegistro().add(
                new ClienteRegistro("Juan", "correo@test.com","Perez")
        );
    }

    @Test
    void buscarCliente() {
        controller.TxtEmail.setText("correo@test.com");

        Optional<ClienteRegistro> encontrado = controller.buscarCliente();

        assertTrue(encontrado.isPresent());
        assertEquals("correo@test.com", encontrado.get().getCorreo());
    }

    @Test
    void validarCliente() {
        controller.TxtEmail.setText("correo@test.com");
        controller.TxtContrasena.setText("1234");

        Optional<ClienteRegistro> valido = controller.validarCliente();

        assertTrue(valido.isPresent());
        assertEquals("1234", valido.get().getContrasena());
    }

    @Test
    void onIniciarSesion() {

        controller.TxtEmail.setText("correo@test.com");
        controller.TxtContrasena.setText("1234");

        Optional<ClienteRegistro> resultado = controller.validarCliente();

        assertTrue(resultado.isPresent(), "El login debería ser válido");
    }
}
