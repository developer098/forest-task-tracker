package aim.foresttracker.config;

import aim.foresttracker.config.epam.SecurityConfig;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.context.annotation.Bean;
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
//@Import({SecurityConfiguration.class})
@Import({SecurityConfig.class})
class RootContextConfiguration {
    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
//        DeserializationConfig deserializationConfig = mapper.getDeserializationConfig();
//        deserializationConfig.setDateFormat(new SimpleDateFormat(<my format>));
        mapper.configure(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE, false);
        return mapper;
    }

}
