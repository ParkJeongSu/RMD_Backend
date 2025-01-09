package com.jspark.rdmbackend.controller;


import com.jspark.rdmbackend.dto.ReplyDto;
import com.jspark.rdmbackend.dto.RmdColorSetDto;
import com.jspark.rdmbackend.dto.RmdFactoryDto;
import com.jspark.rdmbackend.entity.RmdColorSet;
import com.jspark.rdmbackend.entity.RmdFactory;
import com.jspark.rdmbackend.service.RmdColorSetService;
import com.jspark.rdmbackend.service.RmdFactoryService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/rmdcolorset")
public class RmdColorSetController {
    private final RmdColorSetService rmdColorSetService;

    public RmdColorSetController(RmdColorSetService rmdColorSetService) {
        this.rmdColorSetService = rmdColorSetService;
    }

    @GetMapping
    public ReplyDto<List<RmdColorSetDto>> getAllrmdColorSetList() {
        return rmdColorSetService.getAllRmdColorSet();
    }

    @PostMapping("/update")
    public ReplyDto<RmdColorSetDto> updatermdColorSet(@RequestBody RmdColorSetDto rmdFactorySetDto) {
        return rmdColorSetService.deleteRmdFactory(rmdFactorySetDto);
    }

    @PostMapping("/create")
    public ReplyDto<RmdColorSetDto> creatermdColorSet(@RequestBody RmdColorSetDto rmdFactorySetDto) {
        return rmdColorSetService.createRmdColorSet(rmdFactorySetDto);
    }

    @DeleteMapping
    public ReplyDto<RmdColorSetDto> deltermdColorSet(@RequestBody RmdColorSetDto rmdFactorySetDto) {
        return rmdColorSetService.deleteRmdFactory(rmdFactorySetDto);
    }
}
