package sb_email;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import sb_email.views.conc.CreatingPage;
import sb_email.views.conc.WelcomePage;

/**
 * Created by Сергей on 23.01.2017.
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration

public class Application {
    public static void main (String[] args){
//        WelcomePage wp = new WelcomePage();
//        CreatingPage cp = new CreatingPage();
//        System.out.println(cp.getPage());

        SpringApplication.run(Application.class, args);
    }
}
