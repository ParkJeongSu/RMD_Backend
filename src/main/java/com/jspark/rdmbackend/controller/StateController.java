package com.jspark.rdmbackend.controller;


import com.jspark.rdmbackend.dto.StateDto;
import com.jspark.rdmbackend.dto.UserprofileDto;
import com.jspark.rdmbackend.entity.State;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/state")
public class StateController {

    private final SimpMessagingTemplate messagingTemplate;

    public StateController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @PostMapping("/change")
    public ResponseEntity<State> changeState(@RequestBody StateDto stateDto) {
        State state = new State();
        state.setObjectName(stateDto.getObjectName());
        state.setStateName(stateDto.getStateName());
        state.setStateValue(stateDto.getStateValue());
        messagingTemplate.convertAndSend("/topic/state",stateDto);
        return ResponseEntity.ok(state);
    }
}
