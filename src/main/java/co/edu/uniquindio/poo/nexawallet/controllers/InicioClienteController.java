package co.edu.uniquindio.poo.nexawallet.controllers;

import co.edu.uniquindio.poo.nexawallet.NexaWAplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import co.edu.uniquindio.poo.nexawallet.clases.*;

public class InicioClienteController {

    @FXML
    private Label BtnCerrarSesion;

    @FXML
    private Label BtnDepositar;

    @FXML
    private Button BtnDepositarMain;

    @FXML
    private Label BtnDetalles;

    @FXML
    private Pane BtnInicio;

    @FXML
    private Label BtnRetirar;

    @FXML
    private Button BtnRetirarMain;

    @FXML
    private Label BtnTransaccion;

    @FXML
    private Button BtnTransferirMain;

    @FXML
    private Label TxtNombreUsuario;

    @FXML
    private Label TxtPuntos;

    @FXML
    private Label TxtRango;

    @FXML
    private Label TxtSaldo;

    @FXML
    private TableView<?> tablaTransacciones;

    @FXML
    public void initialize() {
        tablaTransacciones.lookupAll(".column-header .label").forEach(label -> {
            label.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");
        });

        cambiarNombre();
        cambiarPuntos();
        cambiarSaldo();
    }

    public void cambiarNombre(){
        TxtNombreUsuario.setText(NexaWAplication.getClienteActual().getNombres() + "!");
    }
    public void cambiarPuntos(){
        TxtPuntos.setText(NexaWAplication.getClienteActual().getPuntos() + "");
    }
    public void cambiarSaldo(){
        TxtSaldo.setText(NexaWAplication.getClienteActual().getSaldo() + "");
    }
    public void cambiarRango(){

    }

    @FXML
    void onChangeTransaccion(MouseEvent event){
        NexaWAplication.changeScene("transaccion-view.fxml");
    }


    @FXML
    void onCerrarSesion(MouseEvent event) {
        NexaWAplication.changeScene("login.fxml");
    }

    @FXML
    void onChangeDepositar1(ActionEvent event) {
        NexaWAplication.changeScene("depositar-view.fxml");
    }

    @FXML
    void onChangeDetalle(MouseEvent event) {
        NexaWAplication.changeScene("informacionCuenta-view.fxml");
    }

    @FXML
    void onChangeRetirar1(MouseEvent event) {
        NexaWAplication.changeScene("retirar-view.fxml");
    }

    @FXML
    void onChangeDepositar(MouseEvent event) {
        NexaWAplication.changeScene("depositar-view.fxml");
    }

    @FXML
    void onChangeInicio(MouseEvent event) {
        NexaWAplication.changeScene("inicioUsuario.fxml");
    }

    @FXML
    void onChangeRetirar(ActionEvent event) {
        NexaWAplication.changeScene("retirar-view.fxml");
    }

    @FXML
    void onChangeTransferir(ActionEvent event) {
        NexaWAplication.changeScene("transaccion-view.fxml");
    }
}

