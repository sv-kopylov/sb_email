package sb_email;

import org.hibernate.jpa.boot.spi.EntityManagerFactoryBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.scheduling.annotation.EnableScheduling;
import sb_email.views.conc.CreatingPage;
import sb_email.views.conc.WelcomePage;

/**
 * Created by Сергей on 23.01.2017.
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableScheduling

public class Application {
    public static void main (String[] args){
        SpringApplication.run(Application.class, args);
    }


}
