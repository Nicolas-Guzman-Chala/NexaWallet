module co.edu.uniquindio.poo.nexawallet {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens co.edu.uniquindio.poo.nexawallet.controllers to javafx.fxml;
    opens co.edu.uniquindio.poo.nexawallet to javafx.fxml;
    exports co.edu.uniquindio.poo.nexawallet;
}