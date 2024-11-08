package filtres;


import javax.ws.rs.NameBinding;
import java.lang.annotation.*;



@NameBinding //pour association
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD })
public @interface Secured {

}
