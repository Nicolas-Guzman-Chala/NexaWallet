package co.edu.uniquindio.poo.nexawallet.controllers;
import co.edu.uniquindio.poo.nexawallet.NexaWAplication;
import co.edu.uniquindio.poo.nexawallet.clases.Cliente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.util.Optional;

public class TransferenciaController {

        @FXML
        private Label BtnCerrarSesion;

        @FXML
        private Label BtnDepositar;

        @FXML
        private Label BtnDetalles;

        @FXML
        private Button BtnEnviar;

        @FXML
        private Pane BtnInicio;

        @FXML
        private Button BtnProgramar;

        @FXML
        private Label BtnRetirar;

        @FXML
        private Label BtnTransaccion;

        @FXML
        private Label TxtInicio;

        @FXML
        private TextField InputCelular;

        @FXML
        private TextField InputMonto;

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
        void onEnviar(ActionEvent event) {
            double monto = Double.parseDouble(InputMonto.getText());
            double descuento = NexaWAplication.getClienteActual().getDescuento() / 100;

            System.out.println(descuento);
            if(buscarCliente().isPresent()){
                Optional<Cliente> cliente = buscarCliente();
                Cliente clienteExistente = cliente.get();

                if(clienteExistente.getNumero().equals(NexaWAplication.getClienteActual().getNumero())){
                    mostrarAlerta("Error", "¿Por qué te lo mandas a ti mismo tonto?");
                    throw new IllegalArgumentException("¿Por qué te lo mandas a ti mismo tonto?");
                }else{
                    clienteExistente.setSaldo(clienteExistente.getSaldo() + monto);
                    if(monto < NexaWAplication.getClienteActual().getSaldo()){
                        if(monto >= 100){
                            int cantidadPuntos = (int) monto / 100;
                            NexaWAplication.getClienteActual().setPuntos(NexaWAplication.getClienteActual().getPuntos() + (cantidadPuntos*3));
                            System.out.println(NexaWAplication.getClienteActual().getPuntos());
                        }
                        NexaWAplication.getClienteActual().setSaldo((NexaWAplication.getClienteActual().getSaldo() + (monto * descuento)) - monto);
                        NexaWAplication.getClienteActual().setDescuento(0);
                        InputCelular.clear();
                        InputMonto.clear();
                        mostrarAlerta("Éxito", "Se transferido con éxito");
                    }else{
                        mostrarAlerta("Error", "La transferencia no puede ser mayor a tu saldo");
                        throw new IllegalArgumentException("La transferencia no puede ser mayor a tu saldo");
                    }
                }
            }else{
                mostrarAlerta("Error", "El celular al cual desea transferir \n no se encuentra registrado");
            }
        }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

        public Optional<Cliente> buscarCliente(){
            return NexaWAplication.getListaClientes().stream().filter(c -> c.getNumero().equals(InputCelular.getText())).findFirst();
        }

        @FXML
        void onProgramar(ActionEvent event) {
            NexaWAplication.changeScene("transaccionProgramada-view.fxml");
        }

    }

