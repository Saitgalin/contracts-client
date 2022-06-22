module com.test.contractsclient {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;
    requires java.net.http;
    requires com.fasterxml.jackson.databind;


    opens com.test.contractsclient to javafx.fxml;
    exports com.test.contractsclient;
}