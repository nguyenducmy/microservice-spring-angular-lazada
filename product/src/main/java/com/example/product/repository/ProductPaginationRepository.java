package com.example.product.repository;

import com.example.product.entity.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductPaginationRepository extends PagingAndSortingRepository<Product, Long> {
    List<Product> findAllByCategory(String category, Pageable pageable);
}
