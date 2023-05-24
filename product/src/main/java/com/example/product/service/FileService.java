package com.example.product.service;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.Map;
import java.util.UUID;

@Service
public class FileService {
    public void uploadFileService(HttpServletRequest request) throws IOException {
        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
        Map<String, MultipartFile> files =  multipartHttpServletRequest.getFileMap();
        MultipartFile image = files.get("file");
        ClassPathResource pathResource = new ClassPathResource("src/main/resources/images/");
        File imageDest = new File(pathResource.getPath() + "Product_" + UUID.randomUUID());
        try {
            image.transferTo(imageDest.toPath());
        } catch (NoSuchFileException e) {
            System.out.println(e);
        }
    }
}
