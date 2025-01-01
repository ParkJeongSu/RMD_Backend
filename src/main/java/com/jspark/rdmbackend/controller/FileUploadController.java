package com.jspark.rdmbackend.controller;

import com.jspark.rdmbackend.service.FileStorageService;
import com.jspark.rdmbackend.service.RmdFactoryService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file/upload")
public class FileUploadController {

    private final FileStorageService fileStorageService;
    private final RmdFactoryService rmdFactoryService;

    public FileUploadController(FileStorageService fileStorageService,RmdFactoryService rmdFactoryService) {
        this.fileStorageService = fileStorageService;
        this.rmdFactoryService = rmdFactoryService;
    }

    @PostMapping
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            String fileName = file.getOriginalFilename().substring(0, file.getOriginalFilename().lastIndexOf('.'));
            rmdFactoryService.createRmdFactory(fileName);
            String path = fileStorageService.storeFile(file);
            return "File uploaded to: " + path;
        } catch (Exception e) {
            return "Upload failed: " + e.getMessage();
        }
    }
}
