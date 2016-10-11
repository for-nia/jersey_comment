package annotation;

import javax.ws.rs.NameBinding;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by fornia on 16/10/11.
 */
@Target({ ElementType.TYPE, ElementType.METHOD })
@NameBinding
@Retention(RetentionPolicy.RUNTIME)
public @interface Compress {
}
