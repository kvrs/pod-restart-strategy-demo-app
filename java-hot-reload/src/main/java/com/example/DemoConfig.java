package com.example.hotreload;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "demo")
public class DemoConfig {
    private String message;
    private boolean flag;
    private int version;

    public String getMessage() { return message; }
    public void setMessage(String m) { message = m; }

    public boolean isFlag() { return flag; }
    public void setFlag(boolean f) { flag = f; }

    public int getVersion() { return version; }
    public void setVersion(int v) { version = v; }
}