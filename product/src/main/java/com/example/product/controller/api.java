package com.example.product.controller;

import com.example.product.dto.ProductResponse;
import com.example.product.entity.Product;
import com.example.product.repository.ProductRepository;
import com.example.product.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;


@RestController
@RequestMapping("/api/v1/product")
@CrossOrigin(origins = {"http://localhost:4200",
                        "http://localhost:5000"})
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
    ProductService productService;

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
        productService.addProductService(request);
        return ResponseEntity.ok("Product Added Successfully");
    }
    @PatchMapping("/edit-product")
    public ResponseEntity<String> editProduct(HttpServletRequest request) throws IOException {
        productService.editProductService(request);
        return ResponseEntity.ok("Edit Successfully");
    }

    @PostMapping("/get-products-by-category")
    public ResponseEntity<List<ProductResponse>>  getProductsByCategory(@RequestBody String category) throws IOException {
        List<Product> products = productRepository.findByCategory(category);
        List<ProductResponse> res = new ArrayList<>();
        for (Product i: products){
            String imageName = i.getImageId();
            File file = new File("src/main/resources/images/" + imageName);
            Path path = file.toPath();
            System.out.println(path.toUri());
            String encodeImage = Base64.getEncoder().withoutPadding().encodeToString(Files.readAllBytes(path));
            System.out.println(encodeImage);
            ProductResponse productResponse = new ProductResponse();
            productResponse.setCategory(i.getCategory());
            productResponse.setImage(encodeImage);
            productResponse.setTitle(i.getTitle());
            productResponse.setPrice(i.getPrice());
            productResponse.setDescribe(i.getProductDescribe());
            res.add(productResponse);
        }
        return ResponseEntity.ok(res);
    }
}
