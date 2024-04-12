package kz.kbtu.demotest;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


@SpringBootApplication
public class DemotestApplication {

    public static void main(String[] args) {

        SpringApplication.run(DemotestApplication.class, args);
    }

}
