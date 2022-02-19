package com.padre.luis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@SpringBootApplication
public class LuisApplication {

    public static void main(String[] args) {
        SpringApplication.run(LuisApplication.class, args);
    }

}
