package web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import model.config.ModelConfig;
import persistence.config.PersistenceConfig;
import service.config.ServiceConfig;

@Configuration
@EnableAutoConfiguration
@Import({ModelConfig.class, PersistenceConfig.class, ServiceConfig.class})
@ComponentScan
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
