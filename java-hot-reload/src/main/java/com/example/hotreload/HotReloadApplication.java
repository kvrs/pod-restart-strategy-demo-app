package com.example.hotreload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(DemoConfig.class)
public class HotReloadApplication {
    public static void main(String[] args) {
        SpringApplication.run(HotReloadApplication.class, args);
    }
}
