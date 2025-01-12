package org.example.mpr_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@ComponentScan(basePackages = {"org.example.core", "org.example.api", "org.example.web"})
public class MprProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(MprProjectApplication.class, args);
    }

}
