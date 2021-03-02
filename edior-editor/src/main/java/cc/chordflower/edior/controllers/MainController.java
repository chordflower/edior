package cc.chordflower.edior.controllers;

import cc.chordflower.edior.global.FxController;
import cc.chordflower.edior.global.annotations.CdiFxController;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

@ApplicationScoped
@CdiFxController( "main_window.fxml" )
@Named("mainController")
public class MainController implements FxController {
  private final Parent parent;

  @Inject
  public MainController( FXMLLoader loader ) throws IOException {
    loader.setController( this );
    this.parent = loader.load();
  }

  @Override
  public Parent getViewRoot( ) {
    return this.parent;
  }
}
