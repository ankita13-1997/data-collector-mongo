package com.example.sampledatacollector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.sampledatacollector")
public class SampleDataCollectorApplication {

    public static void main(String[] args) {
        SpringApplication.run(SampleDataCollectorApplication.class, args);
    }



}
