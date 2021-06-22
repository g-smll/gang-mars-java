package gang.org.springframework.boot.autoconfigure;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@GEnableAutoConfiguration
public @interface GSpringBootApplication {
}
