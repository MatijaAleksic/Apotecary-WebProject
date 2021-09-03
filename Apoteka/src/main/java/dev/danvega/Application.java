package dev.danvega;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*@Configuration
@EnableAutoConfiguration
@ComponentScan*/

/*(scanBasePackages = {"dev.danvega.Controller", "dev.danvega.DTO", "dev.danvega.exception", "dev.danvega.Mapper"
        , "dev.danvega.Model", "dev.danvega.Repository", "dev.danvega.security", "dev.danvega.Services"})
 */

//@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
