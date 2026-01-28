package com.example.hotreload;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
@RefreshScope
public class DemoController {

    private final DemoConfig config;

    public DemoController(DemoConfig config) {
        this.config = config;
    }

    @GetMapping("/config")
    public Map<String, Object> getConfig() {
        return Map.of(
            "message", config.getMessage(),
            "flag", config.isFlag(),
            "version", config.getVersion()
        );
    }
}