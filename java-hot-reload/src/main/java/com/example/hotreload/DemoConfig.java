package com.example.hotreload;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "demo")
public class DemoConfig {

    private String message;
    private boolean flag;
    private int version;

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public boolean isFlag() { return flag; }
    public void setFlag(boolean flag) { this.flag = flag; }

    public int getVersion() { return version; }
    public void setVersion(int version) { this.version = version; }
}
