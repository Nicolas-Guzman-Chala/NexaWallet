package co.edu.uniquindio.poo.nexawallet.controllers;

import co.edu.uniquindio.poo.nexawallet.NexaWAplication;
import co.edu.uniquindio.poo.nexawallet.clases.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class DepositarController {

    @FXML
    private Label BtnCerrarSesion;

    @FXML
    private Label BtnDepositar;

    @FXML
    private Button BtnDepositar2;

    @FXML
    private Label BtnDetalles;

    @FXML
    private Pane BtnInicio2;

    @FXML
    private Label BtnRetirar;

    @FXML
    private Label BtnTransaccion;

    @FXML
    private TextField TxtMonto;

    @FXML
    private Label imgs;

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
    void onDepositar(ActionEvent event) {
        float monto = Float.parseFloat(TxtMonto.getText());
        NexaWAplication.getClienteActual().setSaldo(NexaWAplication.getClienteActual().getSaldo() + monto);
        mostrarAlerta("Éxito", "El Saldo se ha cambiado exitósamente");
        if(monto >= 100){
            int cantidadPuntos = (int) monto / 100;
            NexaWAplication.getClienteActual().setPuntos(NexaWAplication.getClienteActual().getPuntos() + (cantidadPuntos));
            System.out.println(NexaWAplication.getClienteActual().getPuntos());
        }
        TxtMonto.clear();

    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

}

