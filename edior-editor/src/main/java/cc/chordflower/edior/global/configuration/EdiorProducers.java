package cc.chordflower.edior.global.configuration;

import cc.chordflower.edior.global.annotations.CdiFxController;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.enterprise.inject.spi.InjectionPoint;
import javafx.fxml.FXMLLoader;
import org.apache.deltaspike.core.api.provider.BeanProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;

@ApplicationScoped
public class EdiorProducers {

  @Produces
  public Logger getLogger( InjectionPoint injectionPoint ) {
    return LoggerFactory.getLogger( injectionPoint.getBean().getBeanClass() );
  }

  @Produces
  public FXMLLoader getLoader( InjectionPoint injectionPoint ) {
    FXMLLoader loader = new FXMLLoader( );
    loader.setControllerFactory( ctrlClass -> BeanProvider.getContextualReference( ctrlClass, false, CdiFxController.Literal.INSTANCE ) );
    if( injectionPoint.getAnnotated().isAnnotationPresent( CdiFxController.class ) ) {
      var annotation = injectionPoint.getAnnotated().getAnnotation( CdiFxController.class );
      var fxmlValue = annotation.value();
      loader.setLocation( injectionPoint.getBean().getBeanClass().getResource( fxmlValue ) );
      loader.setCharset( StandardCharsets.UTF_8 );
    }
    return loader;
  }
}
