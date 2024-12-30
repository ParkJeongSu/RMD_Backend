package com.jspark.rdmbackend.controller;

import com.jspark.rdmbackend.service.FileStorageService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file/upload")
public class FileUploadController {

    private final FileStorageService fileStorageService;

    public FileUploadController(FileStorageService fileStorageService) {
        this.fileStorageService = fileStorageService;
    }

    @PostMapping
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            String path = fileStorageService.storeFile(file);
            return "File uploaded to: " + path;
        } catch (Exception e) {
            return "Upload failed: " + e.getMessage();
        }
    }
}
