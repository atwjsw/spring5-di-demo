package guru.springframework.config;

import guru.springframework.services.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
public class GreetingServiceConfig {

    @Bean
    GreetingRepository greetingRepository() {
        return new GreetingRepositoryImpl();
    }

    @Bean
    GreetingServiceFactory greetingServiceFactory(GreetingRepository greetingRepository) {
        return new GreetingServiceFactory(greetingRepository);
    }

    @Bean
    GreetingService greetingServiceImpl() {
        return new GreetingServiceImpl();
    }

    @Bean
    @Primary
    @Profile({"en", "default"})
    GreetingService primaryGreetingSerive(GreetingServiceFactory greetingServiceFactory) {
        return greetingServiceFactory.greetingService("en");
    }

    @Bean
    @Profile("es")
    @Primary
    GreetingService primarySpanishGreetingService(GreetingServiceFactory greetingServiceFactory) {
        return greetingServiceFactory.greetingService("es");
    }

    @Bean
    @Primary
    @Profile("de")
    GreetingService primaryGermanGreetingService(GreetingServiceFactory greetingServiceFactory) {
        return greetingServiceFactory.greetingService("de");
    }

}
