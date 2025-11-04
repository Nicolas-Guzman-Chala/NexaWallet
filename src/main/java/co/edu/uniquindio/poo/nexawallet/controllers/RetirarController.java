package co.edu.uniquindio.poo.nexawallet.controllers;

import co.edu.uniquindio.poo.nexawallet.NexaWAplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class RetirarController {

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
    private Button BtnRetirar;

    @FXML
    private Label BtnRetirar2;

    @FXML
    private Label BtnTransaccion;

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
    void onRetirar(ActionEvent event) {
        float monto = Float.parseFloat(TxtMonto.getText());
        if(monto > NexaWAplication.getClienteActual().getSaldo()){
            mostrarAlerta("Error", "El retiro no puede superar el saldo actual");
            throw new IllegalArgumentException("El retiro no puede superar el saldo actual");
        }else{
            if(monto >= 100){
                int cantidadPuntos = (int) monto / 100;
                NexaWAplication.getClienteActual().setPuntos(NexaWAplication.getClienteActual().getPuntos() + (cantidadPuntos*2));
                System.out.println(NexaWAplication.getClienteActual().getPuntos());
            }
            NexaWAplication.getClienteActual().setSaldo(NexaWAplication.getClienteActual().getSaldo() - monto);
            mostrarAlerta("Éxito", "El Saldo se ha cambiado exitósamente");
            TxtMonto.clear();
        }
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

}

