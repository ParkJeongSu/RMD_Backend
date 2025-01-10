package com.jspark.rdmbackend.service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

@Service
public class FileStorageService {

    @Value("${file.upload.dir}")
    private String uploadDir;

    private static final Logger logger = LoggerFactory.getLogger(FileStorageService.class);

    public String storeFile(MultipartFile file) throws IOException {

        logger.info("info");
        logger.debug("debug");
        logger.warn("warn");
        logger.error("error");

        if (!file.getOriginalFilename().endsWith(".svg") ) {
            throw new RuntimeException("Only SVG files are allowed.");
        }


        // 저장 경로 생성 (존재하지 않으면 생성)
        Path uploadPath = Paths.get(uploadDir);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        // 파일 저장
        Path filePath = uploadPath.resolve(file.getOriginalFilename());
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        return filePath.toString();  // 저장된 파일 경로 반환
    }
}