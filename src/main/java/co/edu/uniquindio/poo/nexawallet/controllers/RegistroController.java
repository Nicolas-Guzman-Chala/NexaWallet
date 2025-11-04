package co.edu.uniquindio.poo.nexawallet.controllers;

import co.edu.uniquindio.poo.nexawallet.NexaWAplication;
import co.edu.uniquindio.poo.nexawallet.clases.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class RegistroController {

    @FXML
    private TextField TxtNombre;

    @FXML
    private TextField TxtEmail;

    @FXML
    private PasswordField TxtContrasena;

    private static List<ClienteRegistro> listaClientesRegistro = new LinkedList<>();

    public static List<ClienteRegistro> getListaClientesRegistro() {
        return listaClientesRegistro;
    }

    @FXML
    void onChangeRegistro(ActionEvent event) {
        NexaWAplication.changeScene("login.fxml");
    }

    @FXML
    public void onAgregarCliente(ActionEvent event) {
        String nombre = TxtNombre.getText();
        String correo = TxtEmail.getText();
        String contrasena = TxtContrasena.getText();

        if (nombre.isEmpty() || correo.isEmpty() || contrasena.isEmpty()) {
            mostrarAlerta("Error", "Todos los campos son obligatorios.");
            return;
        }

        if(correo.contains("@")){
            if(contrasena.length() >= 6){
                Optional<ClienteRegistro> clienteExistente = listaClientesRegistro.stream()
                        .filter(c -> c.getCorreo().equals(correo))
                        .findFirst();

                if (clienteExistente.isPresent()) {
                    mostrarAlerta("Error", "Ya existe un usuario con este correo.");
                } else {
                    ClienteRegistro nuevoCliente = new ClienteRegistro(nombre, correo, contrasena);
                    listaClientesRegistro.add(nuevoCliente);

                    NexaWAplication.guardarClienteDesdeRegistro(nuevoCliente);

                    mostrarAlerta("Éxito", "Registro completado con éxito.");
                    NexaWAplication.changeScene("login.fxml");
                }
            }
            else{
                mostrarAlerta("Error", "La contraseña debetener más de 6 caracteres");
                throw new IllegalArgumentException("La contraseña debetener más de 6 caracteres");
            }
        }
        else{
            mostrarAlerta("Error", "El correo no es válido");
            throw new IllegalArgumentException("El correo no es válido");
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
