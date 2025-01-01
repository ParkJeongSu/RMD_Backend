package com.jspark.rdmbackend.controller;


import com.jspark.rdmbackend.dto.RmdColorSetDto;
import com.jspark.rdmbackend.entity.RmdColorSet;
import com.jspark.rdmbackend.entity.RmdFactory;
import com.jspark.rdmbackend.service.RmdColorSetService;
import com.jspark.rdmbackend.service.RmdFactoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/rmdcolorset")
public class RmdColorSetController {
    private RmdColorSetService rmdColorSetService;

    public RmdColorSetController(RmdColorSetService rmdColorSetService) {
        this.rmdColorSetService = rmdColorSetService;
    }

    @GetMapping
    public List<RmdColorSetDto> getAllrmdColorSetList() {
        List<RmdColorSetDto> rmdColorSetDtoList = rmdColorSetService.getAllRmdColorSet();
        return rmdColorSetDtoList;
    }
}
