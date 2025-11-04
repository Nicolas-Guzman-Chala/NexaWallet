package co.edu.uniquindio.poo.nexawallet.controllers;

import co.edu.uniquindio.poo.nexawallet.NexaWAplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class TransferenciaProgramadaController {

    @FXML
    private Label BtnCerrarSesion;

    @FXML
    private Button BtnComun;

    @FXML
    private Label BtnDepositar;

    @FXML
    private Label BtnDetalles;

    @FXML
    private Button BtnEnviar;

    @FXML
    private Label BtnInicio;

    @FXML
    private Label BtnRetirar;

    @FXML
    private Label BtnTransaccion;

    @FXML
    private TextField TxtCantidadDias;

    @FXML
    private TextField TxtCelular;

    @FXML
    private TextField TxtFechaFinal;

    @FXML
    private TextField TxtFechaInicial;

    @FXML
    private TextField TxtMonto;

    @FXML
    void onCangeTransaccion(MouseEvent event) {
        NexaWAplication.changeScene("transaccion-view.fxml");
    }

    @FXML
    void onCerrarSesion(MouseEvent event) {
        NexaWAplication.changeScene("login.fxml");
    }

    @FXML
    void onChangeDepositar(MouseEvent event) {
        NexaWAplication.changeScene("depositar-view.fxml");
    }

    @FXML
    void onChangeDetalle(MouseEvent event) {
        NexaWAplication.changeScene("informacionCuenta-view.fxml");
    }

    @FXML
    void onChangeInicio(MouseEvent event) {
        NexaWAplication.changeScene("inicioUsuario.fxml");
    }

    @FXML
    void onChangeRetirar(MouseEvent event) {
        NexaWAplication.changeScene("retirar-view.fxml");
    }

    @FXML
    void onChangeTransaccion(ActionEvent event) {
        NexaWAplication.changeScene("transaccion-view.fxml");
    }

    @FXML
    void onEnviar(ActionEvent event) {

    }

}

