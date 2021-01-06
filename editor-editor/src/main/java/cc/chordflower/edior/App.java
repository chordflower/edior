package cc.chordflower.edior;

import org.apache.deltaspike.cdise.api.CdiContainer;
import org.apache.deltaspike.cdise.api.CdiContainerLoader;
import org.apache.deltaspike.cdise.api.ContextControl;
import jakarta.enterprise.context.ApplicationScoped;

public class App {

    public static void main(String[] args) {
        CdiContainer cdiContainer = CdiContainerLoader.getCdiContainer();
        cdiContainer.boot();
        Runtime.getRuntime().addShutdownHook( new Thread( cdiContainer::shutdown ) );

        // Starting the application-context enables use of @ApplicationScoped beans
        ContextControl contextControl = cdiContainer.getContextControl();
        contextControl.startContext(ApplicationScoped.class);

        // You can use CDI here
    }

}
