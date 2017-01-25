package sb_email;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Сергей on 23.01.2017.
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application {
    public static void main (String[] args){
        SpringApplication.run(Application.class, args);
    }
}
