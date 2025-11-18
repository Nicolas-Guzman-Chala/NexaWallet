package co.edu.uniquindio.poo.nexawallet.controllers;



import co.edu.uniquindio.poo.nexawallet.NexaWAplication;
import co.edu.uniquindio.poo.nexawallet.clases.*;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.util.Optional;


public class InicioSesionController {

    @FXML
        private Button BtnIniciarSesion;

        @FXML
        private Label BtnRegistrateAqui;

        @FXML
        public PasswordField TxtContrasena;

        @FXML
        public TextField TxtEmail;

        @FXML
        void onChangeRegistrate(MouseEvent event) {
            NexaWAplication.changeScene("register.fxml");
        }

        @FXML
        void onIniciarSesion(ActionEvent event) {

            Optional<ClienteRegistro> clienteRegistroOpr = validarCliente();

            if (clienteRegistroOpr.isPresent()) {

                ClienteRegistro clienteRegistro = clienteRegistroOpr.get();

                Optional<Cliente> clienteExistente = NexaWAplication.getListaClientes().stream().filter(c -> c.getCorreo().equals(clienteRegistro.getCorreo())).findFirst();

                Cliente cliente = clienteExistente.get();

                NexaWAplication.setClienteActual(cliente);
                NexaWAplication.changeScene("inicioUsuario.fxml");
                System.out.println("El correo fue validado Correctamente");
            }else{
                System.out.println("El correo o contraseña incorrectas");
            }
        }

        public Optional<ClienteRegistro> validarCliente(){
            if(buscarCliente().isPresent()){
                return RegistroController.getListaClientesRegistro().stream().filter(c -> c.getCorreo().equals(TxtEmail.getText()) && c.getContrasena().equals(TxtContrasena.getText())).findFirst();
            }else{
                System.out.println("El cliente no existe");
                return null;
            }

        }

    public Optional<ClienteRegistro> buscarCliente(){
        return RegistroController.getListaClientesRegistro().stream()
                .filter(c -> c.getCorreo().equals(TxtEmail.getText()))
                .findFirst();
    }

}
