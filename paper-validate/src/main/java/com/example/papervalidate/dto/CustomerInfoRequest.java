package com.example.papervalidate.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
public class CustomerInfoRequest {
    private String customerName;
    private String bannkAccount;
}
