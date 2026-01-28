package com.example.hotreload;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "demo")
public class DemoConfig {
    private String message = "default";
    private boolean flag = false;
    private int version = 1;

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public boolean isFlag() { return flag; }
    public void setFlag(boolean flag) { this.flag = flag; }

    public int getVersion() { return version; }
    public void setVersion(int version) { this.version = version; }
}
