package com.jspark.rdmbackend.controller;


import com.jspark.rdmbackend.dto.StateDto;
import com.jspark.rdmbackend.entity.State;
import com.jspark.rdmbackend.service.StateService;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/state")
public class StateController {

    private final SimpMessagingTemplate messagingTemplate;
    private final StateService stateService;

    public StateController(SimpMessagingTemplate messagingTemplate,StateService stateService) {
        this.messagingTemplate = messagingTemplate;
        this.stateService = stateService;
    }

    @PostMapping("/change")
    public ResponseEntity<StateDto> changeState(@RequestBody StateDto stateDto) {
        messagingTemplate.convertAndSend("/topic/state",stateDto);
        return ResponseEntity.ok(stateDto);
    }

    @GetMapping
    public List<StateDto> getAllState(){
        return stateService.getAllState();
    }
}
