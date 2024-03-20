module com.example.heshan {
    requires javafx.controls;
    requires javafx.fxml;
            
                requires net.synedra.validatorfx;
            requires org.kordamp.ikonli.javafx;
            requires org.kordamp.bootstrapfx.core;
            
    opens com.example.heshan to javafx.fxml;
    exports com.example.heshan;
}