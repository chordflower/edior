package cc.chordflower.edior;

import cc.chordflower.edior.global.FxController;
import jakarta.enterprise.context.ApplicationScoped;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.deltaspike.cdise.api.CdiContainer;
import org.apache.deltaspike.cdise.api.CdiContainerLoader;
import org.apache.deltaspike.cdise.api.ContextControl;
import org.apache.deltaspike.core.api.provider.BeanProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.bridge.SLF4JBridgeHandler;

public class EdiorApplication extends Application {
  private static final Logger LOGGER = LoggerFactory.getLogger( EdiorApplication.class );

  private CdiContainer container;

  @Override
  public void init( ) throws Exception {
    LOGGER.info( "Starting the container" );
    container = CdiContainerLoader.getCdiContainer( );
    container.boot( );

    LOGGER.info( "Starting the application scoped context" );
    ContextControl contextControl = container.getContextControl( );
    contextControl.startContext( ApplicationScoped.class );
  }

  @Override
  public void start( Stage stage ) throws Exception {
    var controller = BeanProvider.getContextualReference( "mainController", false, FxController.class );
    Scene scene = new Scene( controller.getViewRoot() );
    stage.setScene( scene );
    stage.show();
  }

  @Override
  public void stop( ) throws Exception {
    LOGGER.info( "Stopping the container" );
    container.shutdown();
  }

  public static void main( String[ ] args ) {
    SLF4JBridgeHandler.removeHandlersForRootLogger( );
    SLF4JBridgeHandler.install( );
    Application.launch( EdiorApplication.class, args );
  }
}
