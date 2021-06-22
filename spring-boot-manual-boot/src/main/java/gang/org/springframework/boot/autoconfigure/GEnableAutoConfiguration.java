package gang.org.springframework.boot.autoconfigure;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@GImport(GangAutoConfigurationImportSelector.class)
public @interface GEnableAutoConfiguration {
}
