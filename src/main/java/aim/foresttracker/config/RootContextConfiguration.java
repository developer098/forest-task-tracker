package aim.foresttracker.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;

/**
 *
 */
@Configuration
@ComponentScan(
        basePackages = "aim.foresttracker.site",
        excludeFilters = @ComponentScan.Filter(Controller.class)
)
@Import({SecurityConfiguration.class})
class RootContextConfiguration {

}
