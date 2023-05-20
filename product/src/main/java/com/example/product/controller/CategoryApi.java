package com.example.product.controller;

import com.example.product.entity.Category;
import com.example.product.repository.CategoryRepository;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryApi {
    @Autowired
    CategoryRepository categoryRepository;

    @PostMapping(name = "/add-category")
    public ResponseEntity<String> addCategory(@RequestBody Category category){

        return ResponseEntity.ok("Add Category Successfully!");
    }

    @GetMapping("/get-categories")
    public ResponseEntity<List<Category>> getCategories(){
        List<Category> categoryList = categoryRepository.findAll();

        return ResponseEntity.ok(categoryList);
    }
}
