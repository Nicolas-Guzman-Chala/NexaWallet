package co.edu.uniquindio.poo.nexawallet.controllers;

import co.edu.uniquindio.poo.nexawallet.NexaWAplication;
import co.edu.uniquindio.poo.nexawallet.clases.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class CanjearController {

    @FXML
    private Button BtnCanjear1;

    @FXML
    private Button BtnCanjear2;

    @FXML
    private Button BtnCanjear3;

    @FXML
    private Label BtnCerrarSesion;

    @FXML
    private Label BtnDepositar;

    @FXML
    private Label BtnDetalles;

    @FXML
    private Pane BtnInicio;

    @FXML
    private Label BtnInicio2;

    @FXML
    private Label BtnRetirar2;

    @FXML
    private Label BtnTransaccion;

    @FXML
    private Label TxtPuntos;

    @FXML
    public void initialize(){
        cambiarPuntos();
    }

    void cambiarPuntos(){
        int puntos = NexaWAplication.getClienteActual().getPuntos();
        TxtPuntos.setText(puntos + "");
    }

    @FXML
    void onCangeTransaccion(MouseEvent event) {
        NexaWAplication.changeScene("transaccion-view.fxml");
    }

    @FXML
    void onCanjear1(ActionEvent event) {
        int puntos = NexaWAplication.getClienteActual().getPuntos();
        if(puntos >= 100){
            NexaWAplication.getClienteActual().setPuntos(puntos - 100);
            NexaWAplication.getClienteActual().setDescuento(10);
            NexaWAplication.changeScene("canjear-view.fxml");
        }
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    @FXML
    void onCanjear2(ActionEvent event) {

    }

    @FXML
    void onCanjear3(ActionEvent event) {

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
        NexaWAplication.changeScene("informacionCuenta.fxml");
    }

    @FXML
    void onChangeInicio(MouseEvent event) {
        NexaWAplication.changeScene("inicioUsuario.fxml");
    }

    @FXML
    void onChangeRetirar(MouseEvent event) {
        NexaWAplication.changeScene("retirar-view.fxml");
    }

}
