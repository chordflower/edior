package cc.chordflower.edior.global.annotations;

import jakarta.enterprise.util.AnnotationLiteral;
import jakarta.inject.Qualifier;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * Indicates that a object is a javafx controller for a fxml file.
 */
@Qualifier
@Inherited
@Documented
@Target( ElementType.TYPE )
@Retention( RetentionPolicy.RUNTIME )
public @interface CdiFxController {

  /**
   * The name of the fxml file that the controller uses.
   */
  String value();

  @SuppressWarnings( "ClassExplicitlyAnnotation" )
  class Literal extends AnnotationLiteral< CdiFxController > implements CdiFxController {

    public static final CdiFxController INSTANCE = new Literal();

    private Literal() { }

    /**
     * The name of the fxml file that the controller uses.
     */
    @Override
    public String value( ) {
      return null;
    }
  }
}
