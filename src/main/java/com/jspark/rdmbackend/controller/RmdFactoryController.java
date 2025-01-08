package com.jspark.rdmbackend.controller;


import com.jspark.rdmbackend.dto.RmdFactoryDto;
import com.jspark.rdmbackend.dto.UserprofileDto;
import com.jspark.rdmbackend.entity.RmdFactory;
import com.jspark.rdmbackend.entity.Userprofile;
import com.jspark.rdmbackend.service.RmdFactoryService;
import com.jspark.rdmbackend.service.UserprofileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rmdfactorys")
public class RmdFactoryController {

    private final RmdFactoryService rmdFactoryService;

    public RmdFactoryController(RmdFactoryService rmdFactoryService) {
        this.rmdFactoryService = rmdFactoryService;
    }

    @GetMapping
    public List<RmdFactory> getAllrmdFactoryList() {
        List<RmdFactory> factories = rmdFactoryService.getAllRmdFactory();
        factories.sort(Comparator.comparing(RmdFactory::getPosition));
        return factories;
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateRmdFactory(@RequestBody RmdFactoryDto rmdFactoryDto) {

        boolean updateSuccess = rmdFactoryService.updateRmdFactory(rmdFactoryDto);

        if(updateSuccess)
        {
            return ResponseEntity.ok("updateSuccess");
        }
        else
        {
            return ResponseEntity.status(409).body("updateFail");
        }
    }

    @DeleteMapping
    public ResponseEntity<String> deleteRMDFactory(@RequestBody RmdFactoryDto rmdFactoryDto) {

        boolean deleteSuccess = rmdFactoryService.deleteRmdFactory(rmdFactoryDto);
        if(deleteSuccess)
        {
            return ResponseEntity.ok("deleteSuccess");
        }
        else
        {
            return ResponseEntity.status(409).body("deleteFail");
        }
    }
}
