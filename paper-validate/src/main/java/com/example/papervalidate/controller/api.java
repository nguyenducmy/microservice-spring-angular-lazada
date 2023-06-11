package com.example.papervalidate.controller;

//import com.example.papervalidate.dto.CustomerInfoRequest;
//import com.example.papervalidate.entity.CustomerInfo;
//import com.example.papervalidate.repository.CustomerInfoRepository;
import com.example.papervalidate.service.PdfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Document;

import java.io.IOException;

@RestController
public class api {
//    @Autowired
//    CustomerInfoRepository customerInfoRepository;
    @Autowired
    PdfService pdfService;
    @PostMapping("/save-customer-info")
    public ResponseEntity<String> saveCustomerInfo(@RequestBody MultipartFile pdfFile) throws IOException {
        //parsing pdf file and get customer info
        Document document = pdfService.convertPdf2Html(pdfFile);
        return null;
    }
}
