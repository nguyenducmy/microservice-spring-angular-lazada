package com.example.product.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@Entity
@Table(name= "category")
@Data
@AllArgsConstructor @NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column(name = "photo_id")
    private String photoId;

    @Column(name="category")
    private String category;
}
