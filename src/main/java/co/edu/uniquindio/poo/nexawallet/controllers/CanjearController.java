package co.edu.uniquindio.poo.nexawallet.controllers;

import co.edu.uniquindio.poo.nexawallet.NexaWAplication;
import co.edu.uniquindio.poo.nexawallet.clases.TipoRango;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class CanjearController {

    @FXML
    private Label TxtCosto1, TxtCosto2, TxtCosto3;

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
        cambiarPuntos(); rebajar();
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
        if(puntos >= 50 && validarPlatino()){
            NexaWAplication.getClienteActual().setPuntos(puntos - 50);
            NexaWAplication.getClienteActual().setDescuento(NexaWAplication.getClienteActual().getDescuento() + 10);
            NexaWAplication.changeScene("canjear-view.fxml");
        }else if(puntos >= 100){
            NexaWAplication.getClienteActual().setPuntos(puntos - 100);
            NexaWAplication.getClienteActual().setDescuento(10);
            NexaWAplication.changeScene("canjear-view.fxml");
        }
    }

    void rebajar(){
        if(validarPlatino()){
            TxtCosto1.setText("50");
            TxtCosto2.setText("250");
            TxtCosto3.setText("500");
        }else{
            TxtCosto1.setText("100");
            TxtCosto2.setText("500");
            TxtCosto3.setText("1000");
        }
    }

    boolean validarPlatino(){
        TipoRango tipoRango = NexaWAplication.getClienteActual().getTipoRango();
        if(tipoRango == TipoRango.PLATINO){
            return true;
        }else{
            return false;
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
        int puntos = NexaWAplication.getClienteActual().getPuntos();
        if (puntos >= 250 && validarPlatino()){
            NexaWAplication.getClienteActual().setPuntos(puntos - 250);
            NexaWAplication.getClienteActual().setCargos(0);
            NexaWAplication.changeScene("canjear-view.fxml");
        }else if(puntos >= 500){
            NexaWAplication.getClienteActual().setPuntos(puntos - 500);
            NexaWAplication.getClienteActual().setCargos(0);
            NexaWAplication.changeScene("canjear-view.fxml");
        }
    }

    @FXML
    void onCanjear3(ActionEvent event) {
        int puntos = NexaWAplication.getClienteActual().getPuntos();
        if (puntos >= 500 && validarPlatino()) {
            NexaWAplication.getClienteActual().setPuntos(puntos - 500);
            NexaWAplication.getClienteActual().setSaldo(NexaWAplication.getClienteActual().getSaldo() + 1000);
            NexaWAplication.changeScene("canjear-view.fxml");
        }else if(puntos > 1000){
            NexaWAplication.getClienteActual().setPuntos(puntos - 1000);
            NexaWAplication.getClienteActual().setSaldo(NexaWAplication.getClienteActual().getSaldo() + 1000);
            NexaWAplication.changeScene("canjear-view.fxml");
        }
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
