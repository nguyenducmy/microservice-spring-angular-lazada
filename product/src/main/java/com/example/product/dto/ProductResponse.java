package com.example.product.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.net.URL;

import java.io.File;

@Data
@AllArgsConstructor @NoArgsConstructor
public class ProductResponse {
    private String category;
    private String title;
    private String price;
    private String describe;

    private String image;


}
