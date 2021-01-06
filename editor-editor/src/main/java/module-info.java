module cc.chordflower.edior {
    requires javafx.base;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.media;
    requires javafx.web;
    requires deltaspike.cdictrl.api;
    requires jakarta.cdi;
    requires jakarta.inject;

    opens cc.chordflower.edior to javafx.fxml;
    exports cc.chordflower.edior;
}
