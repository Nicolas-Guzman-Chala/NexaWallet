package co.edu.uniquindio.poo.nexawallet.controllers;
import co.edu.uniquindio.poo.nexawallet.NexaWAplication;
import co.edu.uniquindio.poo.nexawallet.clases.Cliente;
import co.edu.uniquindio.poo.nexawallet.clases.ClienteRegistro;
import co.edu.uniquindio.poo.nexawallet.clases.TipoRango;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.event.ActionEvent;

import static org.junit.jupiter.api.Assertions.*;

class InformacionCuentaControllerTest {

    InicioClienteController controller;


    @BeforeEach
    void setUp() {
        ClienteRegistro registro = new ClienteRegistro(
                "Luisa",
                "luisa@gmail.com",
                "1234"
        );

        Cliente cliente = new Cliente(
                "Luisa",
                "Hernandez",
                "123456789",
                "3001112222",
                "luisa@gmail.com",
                500.0,
                20,
                registro,
                5.0,
                0.0,
                TipoRango.BRONCE
        );

        NexaWAplication.getListaClientes().clear();
        NexaWAplication.getListaClienteRegistro().clear();

        NexaWAplication.getListaClientes().add(cliente);
        NexaWAplication.getListaClienteRegistro().add(registro);

        NexaWAplication.setClienteActual(cliente);
        NexaWAplication.setClienteRegistroActual(registro);

         InformacionCuentaController controller = new InformacionCuentaController();

        controller.InputNombres = new javafx.scene.control.TextField();
        controller.InputApellidos = new javafx.scene.control.TextField();
        controller.InputCedula = new javafx.scene.control.TextField();
        controller.InputNumero = new javafx.scene.control.TextField();
        controller.InputCorreo = new javafx.scene.control.TextField();

        controller.InputNombres.setText("Maria");
        controller.InputApellidos.setText("Gomez");
        controller.InputCedula.setText("987654321");
        controller.InputNumero.setText("3105556666");
        controller.InputCorreo.setText("maria@gmail.com");
    }

}
