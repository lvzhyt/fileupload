package com.tg.upload.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.tg.upload.WebappConfig;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by tg on 2017/10/31.
 */
@Controller
public class fileUploadController {

    @Autowired
    private WebappConfig webappConfig;

    @RequestMapping("fileUpload")
    public String fileUpload(@RequestParam("file") MultipartFile multipartFile, HttpServletRequest request, Model model) throws IOException {

        String contextPath = request.getContextPath();
        String fileName = multipartFile.getOriginalFilename();
        String newFileName = UUID.randomUUID()+fileName;
        ServletContext context = request.getServletContext();
        String path = context.getRealPath("/images")+"/";
        File f = new File(path);
        if(!f.exists()){
            f.mkdirs();
        }
        f = new File(path+newFileName);
        multipartFile.transferTo(f);
        String url = contextPath+"/images/"+newFileName;
        model.addAttribute("url",url);
        return "fileView";
    }

    @RequestMapping("fileUploadJersey")
    public String fileUploadJersey(@RequestParam("file") MultipartFile multipartFile,Model model) throws IOException {
        Client client = new Client();
//        String imageServer="http://localhost:9080/images/";
        String imageServer = webappConfig.getImageServer();
        /*
        *配置Tomcat图片服务器 将端口改为9080
         */
        String name = multipartFile.getOriginalFilename();
        byte[] filebuf = multipartFile.getBytes();
        String url = imageServer+name;
        WebResource resource = client.resource(url);
        resource.put(String.class,filebuf);

        model.addAttribute("url",url);
        return "fileView";
    }

}
