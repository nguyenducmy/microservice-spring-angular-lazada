package com.example.papervalidate.service;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.aspectj.weaver.bcel.ClassPathManager;
import org.fit.pdfdom.PDFDomTree;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Document;


import java.io.*;
import java.nio.file.Path;
import java.util.UUID;

@Service
public class PdfService {
    public Document convertPdf2Html(MultipartFile pdfFile) throws IOException {

        Path path = Path.of("src/main/resources/paper-storage");
        String pdfId = path + "/PDF-" + UUID.randomUUID();
        File file = new File(pdfId);
        file.createNewFile();
        BufferedReader br = new BufferedReader(new FileReader(file));
        while(br.ready()){
            System.out.println(br.readLine());
        }
        pdfFile.transferTo(file);
        PDDocument pdDocument = PDDocument.load(Path.of(pdfId).toFile());
        Document document = new PDFDomTree().createDOM(pdDocument);
        return document;
    }
}
