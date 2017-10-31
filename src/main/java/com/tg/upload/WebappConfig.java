package com.tg.upload;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Created by tg on 2017/10/31.
 */
@Component("webappConfig")
public class WebappConfig {
    @Value("${server.images}")
    private String imageServer;

    public String getImageServer() {
        return imageServer;
    }

    public void setImageServer(String imageServer) {
        this.imageServer = imageServer;
    }
}
