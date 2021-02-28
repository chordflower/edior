package cc.chordflower.edior;

import org.apache.deltaspike.cdise.api.CdiContainer;
import org.apache.deltaspike.cdise.api.CdiContainerLoader;
import org.apache.deltaspike.cdise.api.ContextControl;
import org.slf4j.bridge.SLF4JBridgeHandler;

import jakarta.enterprise.context.ApplicationScoped;

public class App {

  public static void main( String[ ] args ) {
    SLF4JBridgeHandler.removeHandlersForRootLogger( );
    SLF4JBridgeHandler.install( );
    CdiContainer cdiContainer = CdiContainerLoader.getCdiContainer( );
    cdiContainer.boot( );
    Runtime.getRuntime( ).addShutdownHook( new Thread( cdiContainer::shutdown ) );

    // Starting the application-context enables use of @ApplicationScoped beans
    ContextControl contextControl = cdiContainer.getContextControl( );
    contextControl.startContext( ApplicationScoped.class );

    // You can use CDI here

  }

}
