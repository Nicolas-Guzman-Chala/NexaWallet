package co.edu.uniquindio.poo.nexawallet.controllers;

import co.edu.uniquindio.poo.nexawallet.NexaWAplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import co.edu.uniquindio.poo.nexawallet.clases.*;


public class InformacionCuentaController {

    @FXML
    private Button BtnActualizar;

    @FXML
    private Button BtnCanjear;

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
    private ImageView ImgRango;

    @FXML
    private TextField InputApellidos;

    @FXML
    private TextField InputCedula;

    @FXML
    private TextField InputCorreo;

    @FXML
    private TextField InputNombres;

    @FXML
    private TextField InputNumero;

    @FXML
    private Label TxtApellidos;

    @FXML
    private Label TxtCedula;

    @FXML
    private Label TxtCorreo;

    @FXML
    private Label TxtNombres;

    @FXML
    private Label TxtNumero;

    @FXML
    private Label TxtPuntos;

    @FXML
    private Label TxtRango;

    @FXML
    void onActualizar(ActionEvent event) {
        if(!InputNombres.getText().isBlank()){
            NexaWAplication.getClienteActual().setNombres(InputNombres.getText());
            NexaWAplication.getClienteRegistroActual().setNombre(InputNombres.getText());
        }
        if(!InputApellidos.getText().isBlank()){
            NexaWAplication.getClienteActual().setApellidos(InputApellidos.getText());
        }
        if(!InputCedula.getText().isBlank()){
            NexaWAplication.getClienteActual().setCedula(InputCedula.getText());
        }
        if(!InputNumero.getText().isBlank()){
            NexaWAplication.getClienteActual().setNumero(InputNumero.getText());
        }
        if(!InputCorreo.getText().isBlank()){
            NexaWAplication.getClienteActual().setCorreo(InputCorreo.getText());
            NexaWAplication.getClienteRegistroActual().setCorreo(InputCorreo.getText());
        }
        actualizarListas();

        InputNombres.clear();
        InputApellidos.clear();
        InputCedula.clear();
        InputNumero.clear();
        InputCorreo.clear();

        NexaWAplication.changeScene("informacionCuenta-view.fxml");

        System.out.println("Datos actualizados correctamente.");
        mostrarAlerta("Éxito", "Los datos han sido actualizados correctamente");
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    public void initialize() {
        TxtNombres.setText(NexaWAplication.getClienteActual().getNombres());
        TxtApellidos.setText(NexaWAplication.getClienteActual().getApellidos());
        TxtCedula.setText(NexaWAplication.getClienteActual().getCedula());
        TxtNumero.setText(NexaWAplication.getClienteActual().getNumero());
        TxtCorreo.setText(NexaWAplication.getClienteActual().getCorreo());
        TxtPuntos.setText(NexaWAplication.getClienteActual().getPuntos() + "");
    }

    private void actualizarListas() {
        Cliente clienteActualizado = NexaWAplication.getClienteActual();
        ClienteRegistro clienteRegistroActualizado = NexaWAplication.getClienteRegistroActual();

        for (int i = 0; i < NexaWAplication.getListaClientes().size(); i++) {
            Cliente c = NexaWAplication.getListaClientes().get(i);
            if (c.getCorreo().equals(clienteActualizado.getCorreo())) {
                NexaWAplication.getListaClientes().set(i, clienteActualizado);
                break;
            }
        }

        for (int i = 0; i < NexaWAplication.getListaClienteRegistro().size(); i++) {
            ClienteRegistro r = NexaWAplication.getListaClienteRegistro().get(i);
            if (r.getCorreo().equals(clienteRegistroActualizado.getCorreo())) {
                NexaWAplication.getListaClienteRegistro().set(i, clienteRegistroActualizado);
                break;
            }
        }
    }


    @FXML
    void onCangeTransaccion(MouseEvent event) {
        NexaWAplication.changeScene("transaccion-view.fxml");
    }

    @FXML
    void onCerrarSesion(MouseEvent event) {
        NexaWAplication.changeScene("login.fxml");
    }

    @FXML
    void onChangeCanjear(ActionEvent event) {
        NexaWAplication.changeScene("canjear-view.fxml");
    }

    @FXML
    void onChangeDepositar(MouseEvent event) {
        NexaWAplication.changeScene("depositar-view.fxml");
    }

    @FXML
    void onChangeDetalle(MouseEvent event) {
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

