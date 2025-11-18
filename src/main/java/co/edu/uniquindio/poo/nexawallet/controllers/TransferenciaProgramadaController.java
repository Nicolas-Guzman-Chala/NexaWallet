package co.edu.uniquindio.poo.nexawallet.controllers;

import co.edu.uniquindio.poo.nexawallet.NexaWAplication;
import co.edu.uniquindio.poo.nexawallet.clases.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.time.*;
import java.util.Optional;
import java.util.concurrent.ScheduledExecutorService;

public class TransferenciaProgramadaController {

    @FXML
    public DatePicker DateFechaDeEnvio;

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
    public TextField TxtCelular;

    @FXML
    public TextField TxtMonto;

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

    private void mostrarAlerta(String titulo) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(null);
        alerta.showAndWait();
    }

    public Optional<Cliente> buscarCliente(){
        return NexaWAplication.getListaClientes().stream().filter(c -> c.getNumero().equals(TxtCelular.getText())).findFirst();
    }

    @FXML
    void onEnviar(ActionEvent event) {
        int monto = Integer.parseInt(TxtMonto.getText());

        if(buscarCliente().isPresent()){
            Optional<Cliente> cliente = buscarCliente();
            Cliente clienteExistente = cliente.get();
                clienteExistente.setSaldo(clienteExistente.getSaldo() + monto);
                if(monto < NexaWAplication.getClienteActual().getSaldo()){

                    LocalDateTime fechaProgramada = DateFechaDeEnvio.getValue().atStartOfDay();
                    LocalDateTime ahora = LocalDateTime.now();

                    if (fechaProgramada.isBefore(ahora)) {
                        mostrarAlerta("Error", "La fecha debe ser en el futuro");
                        return;
                    }

                    long delay = Duration.between(ahora, fechaProgramada).getSeconds();

                    mostrarAlerta("Éxito", "Tu transferencia ha sido programada para: " + fechaProgramada);

                    ScheduledExecutorService scheduler = java.util.concurrent.Executors.newSingleThreadScheduledExecutor();

                    scheduler.schedule(() -> {
                        javafx.application.Platform.runLater(() -> {

                            clienteExistente.setSaldo(clienteExistente.getSaldo() + monto);
                            NexaWAplication.getClienteActual().setSaldo(
                                    NexaWAplication.getClienteActual().getSaldo() - monto
                            );


                            HistorialTransaccion historial = new HistorialTransaccion(
                                    NexaWAplication.getClienteActual(),
                                    TipoTransaccion.TRASFERENCIAPROGRAMADA,
                                    NexaWAplication.getClienteActual().getPuntos(),
                                    NexaWAplication.getClienteActual().getTipoRango() + "",
                                    monto,
                                    fechaProgramada
                            );

                            NexaWAplication.getClienteActual().setHistorialTransaccion(historial);
                            InicioClienteController.setListaObservable(historial);

                            System.out.println("✔ Transferencia programada ejecutada");

                        });

                    }, delay, java.util.concurrent.TimeUnit.SECONDS);

                    mostrarAlerta("Éxito", "Se ha programado tu transaccion");
                    String tipoRango = NexaWAplication.getClienteActual().getTipoRango() + "";
                    HistorialTransaccion historialTransaccion = new HistorialTransaccion(NexaWAplication.getClienteActual(), TipoTransaccion.TRASFERENCIAPROGRAMADA, NexaWAplication.getClienteActual().getPuntos(), tipoRango, monto, DateFechaDeEnvio.getValue().atStartOfDay());
                    NexaWAplication.getClienteActual().setHistorialTransaccion(historialTransaccion);
                    InicioClienteController.setListaObservable(historialTransaccion);
                }else{
                    mostrarAlerta("Error", "La transferencia no puede ser mayor a tu saldo");
                    throw new IllegalArgumentException("La transferencia no puede ser mayor a tu saldo");
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
}

