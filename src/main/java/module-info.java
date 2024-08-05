module com.math.calculator {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.math.calculator to javafx.fxml;
    exports com.math.calculator;
}