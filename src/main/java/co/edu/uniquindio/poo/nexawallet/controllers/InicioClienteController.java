package co.edu.uniquindio.poo.nexawallet.controllers;

import co.edu.uniquindio.poo.nexawallet.NexaWAplication;
import co.edu.uniquindio.poo.nexawallet.clases.HistorialTransaccion;
import co.edu.uniquindio.poo.nexawallet.clases.TipoRango;
import co.edu.uniquindio.poo.nexawallet.clases.TipoTransaccion;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.util.Objects;

public class InicioClienteController {

    private static ObservableList<HistorialTransaccion> listaObservable;

    public static ObservableList<HistorialTransaccion> getListaObservable() {
        return listaObservable;
    }

    public static void setListaObservable(HistorialTransaccion t) {
        listaObservable.add(t);
    }

    @FXML
    private TableColumn<HistorialTransaccion, TipoTransaccion> colTipo;
    @FXML
    private TableColumn<HistorialTransaccion, Integer> colPuntos;
    @FXML
    private TableColumn<HistorialTransaccion, String> colTipoRango;
    @FXML
    private TableColumn<HistorialTransaccion, Double> colCantidad;
    @FXML
    private TableColumn<HistorialTransaccion, String> colFecha;
    @FXML
    private ImageView imageView;

    @FXML
    private Label BtnCerrarSesion, BtnDepositar, BtnDetalles, BtnRetirar, BtnTransaccion;
    @FXML
    private Pane BtnInicio;
    @FXML
    private Button BtnDepositarMain, BtnRetirarMain, BtnTransferirMain;
    @FXML
    public Label TxtNombreUsuario, TxtPuntos, TxtRango, TxtSaldo;

    @FXML
    private TableView<HistorialTransaccion> tablaTransacciones;

    @FXML
    public void initialize() {

        tablaTransacciones.lookupAll(".column-header .label").forEach(label -> {
            label.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");
        });

        listaObservable = FXCollections.observableArrayList(
                NexaWAplication.getClienteActual().getHistorialTransaccion()
        );


        colTipo.setCellValueFactory(new PropertyValueFactory<>("tipoTransaccion"));
        colPuntos.setCellValueFactory(new PropertyValueFactory<>("puntos"));
        colTipoRango.setCellValueFactory(c ->
                new SimpleStringProperty(
                        c.getValue().getTipoRango()
                )
        );
        colCantidad.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
        colFecha.setCellValueFactory(c ->
                new SimpleStringProperty(c.getValue().getFecha().toString())
        );

        tablaTransacciones.setItems(listaObservable);

        calcularRango();
        cambiarNombre();
        cambiarPuntos();
        cambiarSaldo();
        cambiarRango();

        actualizarImagenRango();
    }

    private void actualizarImagenRango() {

        String ruta = switch (NexaWAplication.getClienteActual().getTipoRango()) {
            case BRONCE -> "/co/edu/uniquindio/poo/nexawallet/imgs/Bronce.png";
            case PLATA -> "/co/edu/uniquindio/poo/nexawallet/imgs/Plata.png";
            case ORO -> "/co/edu/uniquindio/poo/nexawallet/imgs/Oro.png";
            case PLATINO -> "/co/edu/uniquindio/poo/nexawallet/imgs/Platino.png";
            default -> null;
        };

        if (getClass().getResource(ruta) == null) {
            System.out.println("No se encontró la imagen: " + ruta);
            return;
        }

        imageView.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream(ruta))));
    }

    public void cambiarNombre() {
        TxtNombreUsuario.setText(NexaWAplication.getClienteActual().getNombres() + "!");
    }

    public void cambiarPuntos() {
        TxtPuntos.setText(String.valueOf(NexaWAplication.getClienteActual().getPuntos()));
    }

    public void cambiarSaldo() {
        TxtSaldo.setText(String.valueOf(NexaWAplication.getClienteActual().getSaldo()));
    }

    public void cambiarRango() {
        TxtRango.setText(NexaWAplication.getClienteActual().getTipoRango() + "");
    }
     
    TipoRango rangoAnterior = NexaWAplication.getClienteActual().getTipoRango();
    
    public void calcularRango() {
        int puntos = NexaWAplication.getClienteActual().getPuntos();
        if (puntos >= 0 && puntos <= 500) {
            NexaWAplication.getClienteActual().setTipoRango(TipoRango.BRONCE);
            mirarRango();
        } else if (puntos >= 501 && puntos <= 1000) {
            NexaWAplication.getClienteActual().setTipoRango(TipoRango.PLATA);
            NexaWAplication.getClienteActual().setCargos(0);
            mirarRango();
        } else if (puntos >= 1001 && puntos <= 5000) {
            NexaWAplication.getClienteActual().setTipoRango(TipoRango.ORO);
            mirarRango();
        } else {
            NexaWAplication.getClienteActual().setTipoRango(TipoRango.PLATINO);
            mirarRango();
        }
    }
    
    void mirarRango() {
        if (rangoAnterior != NexaWAplication.getClienteActual().getTipoRango()) {
            rangoAnterior = NexaWAplication.getClienteActual().getTipoRango();
            if(NexaWAplication.getClienteActual().getTipoRango() == TipoRango.PLATA){
                mostrarAlerta("¡¡Excelente noticia! Ahora eres Rango PLATA 🥈!!", "A partir de este momento, no se te aplicarán cargos por transacción. ¡Disfruta de tus beneficios!");
            }else if (NexaWAplication.getClienteActual().getTipoRango() == TipoRango.ORO){
                mostrarAlerta("¡¡Felicidades,Haz alcanzado Rango ORO 🥇!!", "Tus puntos se han duplicado como beneficio de tu nuevo rango. ¡Sigue así!");
            }else if (NexaWAplication.getClienteActual().getTipoRango() == TipoRango.PLATINO){
                mostrarAlerta("¡¡QUE CRACK,Has alcanzado el Rango PLATINO 🏅!!", "Desde ahora, necesitarás menos puntos para canjear beneficios y descuentos. ¡Tu fidelidad te abre acceso a recompensas más exclusivas!");
            }
        }
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
    void onChangeDepositar1(MouseEvent event) {
        NexaWAplication.changeScene("depositar-view.fxml");
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
    void onChangeRetirar(ActionEvent event) {
        NexaWAplication.changeScene("retirar-view.fxml");
    }

    @FXML
    void onChangeTransferir(ActionEvent event) {
        NexaWAplication.changeScene("transaccion-view.fxml");
    }

    @FXML
    void onChangeDepositar1(ActionEvent event) {
        NexaWAplication.changeScene("depositar-view.fxml");
    }

    @FXML
    void onChangeTransferir(MouseEvent event) {
        NexaWAplication.changeScene("transaccion-view.fxml");
    }
    @FXML
    void onChangeInicio(MouseEvent event){
        NexaWAplication.changeScene("inicioUsuario.fxml");
    }
    @FXML
    void onChangeRetirar1(MouseEvent event) {
        NexaWAplication.changeScene("retirar-view.fxml");
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}
