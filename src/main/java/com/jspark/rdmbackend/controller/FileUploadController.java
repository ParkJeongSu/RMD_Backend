package com.jspark.rdmbackend.controller;

import com.jspark.rdmbackend.dto.ReplyDto;
import com.jspark.rdmbackend.entity.RmdFactory;
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
    public ReplyDto<RmdFactory> uploadFile(@RequestParam("file") MultipartFile file) {
        ReplyDto<RmdFactory> replyDto = new ReplyDto<RmdFactory>();
        try {
            String fileName = file.getOriginalFilename().substring(0, file.getOriginalFilename().lastIndexOf('.'));
            RmdFactory rmdFactory = rmdFactoryService.createRmdFactory(fileName);
            String path = fileStorageService.storeFile(file);
            replyDto.setSuccess(true);
            replyDto.setData(rmdFactory);
        } catch (Exception e) {
            replyDto.setSuccess(false);
            replyDto.getError().setCode(e.getCause().toString());
            replyDto.getError().setDetailMessage(e.getMessage());
        }

        return replyDto;
    }
}
