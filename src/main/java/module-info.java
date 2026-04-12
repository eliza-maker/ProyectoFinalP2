module co.edu.uniquindio.co.proyectofinalp2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens co.edu.uniquindio.co.proyectofinalp2 to javafx.fxml;
    exports co.edu.uniquindio.co.proyectofinalp2;
}