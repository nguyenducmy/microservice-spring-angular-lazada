package com.example.product.controller;

import com.example.product.config.AppConfig;
import com.example.product.dto.ProductRequest;
import com.example.product.entity.Product;
import com.example.product.repository.ProductRepository;
import com.example.product.service.FileService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/product")
@CrossOrigin(origins = "http://localhost:4200")
public class api {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    HttpServletRequest request;

    @Autowired
    RabbitTemplate rabbitTemplate;
    @Autowired
    Queue queue;

    @Autowired
    ObjectMapper om;

    @Autowired
    ProductRepository productRepository;
    @Autowired
    FileService fileService;

    @GetMapping("/get-products")
    public String getProducts(){
        String url = "http://localhost:8080/api/v1/store/get-stores";
        String bearer = request.getHeader(HttpHeaders.AUTHORIZATION);
        String token = bearer.substring(7);
//        String url = "http://localhost:8083/api/v1/store/get-stores";
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.AUTHORIZATION, token);
        HttpEntity httpEntity = new HttpEntity<>(headers);
        ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
        return "products" + " - " + result.getBody();
    }

    @PostMapping("/add-product")
    public ResponseEntity<String> addProduct(HttpServletRequest request) throws IOException, ServletException {
        fileService.uploadFileService(request);
        return ResponseEntity.ok("Product Added Successfully");
    }
    @PatchMapping("/edit-product")
    public ResponseEntity<String> editProduct(HttpServletRequest request) throws IOException {
        fileService.editProductService(request);
        return ResponseEntity.ok("Edit Successfully");
    }
}
