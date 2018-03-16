package com.github.marcospsbrito.mars;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

/**
 * Created by marcos on 15/03/18.
 */

@Configuration
@EnableAutoConfiguration
@SpringBootApplication
public class MarsCuriosityApplication {
    public static void main(String[] args) {
        SpringApplication.run(MarsCuriosityApplication.class, args);
    }
}
