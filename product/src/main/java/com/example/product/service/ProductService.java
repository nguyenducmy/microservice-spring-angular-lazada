package com.example.product.service;

import com.example.product.dto.ProductRequest;
import com.example.product.entity.Product;
import com.example.product.repository.ProductRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.Arrays;
import java.util.Map;
import java.util.UUID;

@Service
public class ProductService {
    private final String ROOT_PATH = "src/main/resources/images/";
    @Autowired
    ObjectMapper om;
    @Autowired
    ProductRepository productRepository;

    public void addProductService(HttpServletRequest request) throws IOException {
        Map<String, String[]> category = request.getParameterMap();
        String productRequest = Arrays.stream(category.get("body")).findFirst().get();
        System.out.println(productRequest);
        ProductRequest product = om.readValue(productRequest, ProductRequest.class);

        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
        Map<String, MultipartFile> files = multipartHttpServletRequest.getFileMap();
        MultipartFile image = files.get("file");
        ClassPathResource pathResource = new ClassPathResource(ROOT_PATH);
        File imageDest = new File(pathResource.getPath() + "Product_" + UUID.randomUUID());
        System.out.println(imageDest.getName());
        String productImageId = imageDest.getName();
        Product newProduct = new Product();
        newProduct.setCategory(product.getCategory());
        newProduct.setTitle(product.getTitle().trim());
        newProduct.setPrice(product.getPrice());
        newProduct.setProductDescribe(product.getDescribe());
        newProduct.setImageId(productImageId);
        productRepository.save(newProduct);

        try {
            image.transferTo(imageDest.toPath());
        } catch (NoSuchFileException e) {
            System.out.println(e);
        }
    }

    public void editProductService(HttpServletRequest request) throws IOException {
        Map<String, String[]> category = request.getParameterMap();
        String productRequest = Arrays.stream(category.get("body")).findFirst().get();
        System.out.println(productRequest);
        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
        Map<String, MultipartFile> files = multipartHttpServletRequest.getFileMap();
        MultipartFile image = files.get("file");
        ProductRequest product = om.readValue(productRequest, ProductRequest.class);
        Product existProduct = productRepository.findProductByTitle(product.getTitle()).orElseThrow();

        String imageId = existProduct.getImageId();
        Path pathImageId = Path.of(ROOT_PATH + imageId);
        Files.deleteIfExists(pathImageId);
        File imageDest = new File(ROOT_PATH + "Product_" + UUID.randomUUID());
        String productImageId = imageDest.getName();

        existProduct.setPrice(product.getPrice());
        existProduct.setProductDescribe(product.getDescribe());
        existProduct.setImageId(productImageId);
        try {
            image.transferTo(imageDest.toPath());
        } catch (NoSuchFileException e) {
            System.out.println(e);
        }
        productRepository.save(existProduct);
    }
}
