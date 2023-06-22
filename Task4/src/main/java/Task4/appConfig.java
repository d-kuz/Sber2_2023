package Task4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class appConfig {
    @Bean
    public Parser parser(){
        return new parserText();
    }

    @Bean
    public Counter counter(){
        return new counterWorlds();
    }

    @Bean
    public Report report(){
        return new reportWriter();
    }
}
