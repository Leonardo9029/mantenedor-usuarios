module com.argandona.mantenedorusuarios {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.argandona.mantenedorusuarios to javafx.fxml;
    exports com.argandona.mantenedorusuarios;
    opens com.argandona.mantenedorusuarios.controller to javafx.fxml;
    
}