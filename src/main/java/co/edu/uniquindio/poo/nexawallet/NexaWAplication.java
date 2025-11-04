package co.edu.uniquindio.poo.nexawallet;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import co.edu.uniquindio.poo.nexawallet.clases.*;
import java.util.LinkedList;
import java.util.List;

public class NexaWAplication extends Application {
    private static Stage mainStage;
    private static List<Cliente> listaClientes = new LinkedList<>();
    private static Cliente clienteActual;
    private static List<ClienteRegistro> listaClienteRegistro = new LinkedList<>();
    private static ClienteRegistro clienteRegistro;

    @Override
    public void start(Stage stage) throws Exception {
        mainStage = stage;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("register.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setTitle("NexaWallet");
        stage.setScene(scene);
        stage.show();
    }

    public static void changeScene(String fxml) {
        try {
            var url = NexaWAplication.class.getResource(fxml);
            if (url == null) {
                System.err.println("No se encontró el archivo FXML: " + fxml);
                return;
            }
            FXMLLoader loader = new FXMLLoader(url);
            Scene scene = new Scene(loader.load());
            mainStage.setScene(scene);
            mainStage.show();
            System.out.println("Escena cambiada correctamente a: " + fxml);
        } catch (Exception e) {
            System.err.println("Error al cambiar de escena a " + fxml);
            e.printStackTrace();
        }
    }

    // Getters y Setters
    public static List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public static Cliente getClienteActual() {
        return clienteActual;
    }

    public static List<ClienteRegistro> getListaClienteRegistro() {return listaClienteRegistro;}

    public static ClienteRegistro getClienteRegistroActual(){return clienteRegistro;}

    public static void setClienteActual(Cliente cliente) {
        clienteActual = cliente;
    }

    public static void setClienteRegistroActual(ClienteRegistro clienteReg) {
        clienteRegistro = clienteReg;
    }

    //guardar cliente desde el registro o login

    public static void guardarClienteDesdeRegistro(ClienteRegistro clienteRegistro) {
        Cliente cliente = new Cliente(
                clienteRegistro.getNombre(),
                "",
                "",
                "",
                clienteRegistro.getCorreo(),
                0.0,
                0,
                clienteRegistro,
                0
        );

        listaClientes.add(cliente);
        listaClienteRegistro.add(clienteRegistro);

        setClienteActual(cliente);
        setClienteRegistroActual(clienteRegistro);

        System.out.println("Cliente guardado: " + cliente.getNombres());
    }


    public static void main(String[] args) {
        launch(args);
    }
}
