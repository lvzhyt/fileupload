package com.tg.upload;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by lzh on 2017/10/31.
 */
public class Upload {

    public static void main(String[] args) {
        try {
            Client client = new Client();
            String urlServer="http://localhost:9080/images/";
            String name = "2.jpg";
            String filepath = "C:\\Users\\lzh\\Pictures\\pic\\";
            byte[] filebuf = FileUtils.readFileToByteArray(new File(filepath+name));
            String url = urlServer+name;
            WebResource resource = client.resource(url);
            resource.put(String.class,filebuf);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
