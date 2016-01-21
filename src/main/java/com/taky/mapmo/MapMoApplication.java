package com.taky.mapmo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration
public class MapMoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MapMoApplication.class, args);
    }
}
