package com.jspark.rdmbackend.controller;


import com.jspark.rdmbackend.dto.StateDto;
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

    @PostMapping("/test")
    public ResponseEntity<StateDto> testState(@RequestBody StateDto stateDto) {

        boolean A1machine3 = false;
        boolean A1machine6 = false;
        boolean T1machine1 = false;
        for(int i=0;i<1000;i++)
        {
            try {
                Thread.sleep(400); // 2000 밀리초 = 2초
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("2초 후에 다시 실행됩니다.");
            StateDto test= new StateDto();

            int q = (int)(Math.random()*80);

            if(i%2==0)
            {
                test.setObjectName("A1machine" + String.valueOf(q));
                test.setStateName("MachineState");
                test.setStateValue(A1machine3 == true ? "Run" : "Down");
                A1machine3 = !A1machine3;
            }
            else if(i%3==0)
            {
                test.setObjectName("T1machine" + String.valueOf(q));
                test.setStateName("MachineState");
                test.setStateValue(A1machine6 == true ? "Run" : "Down");
                A1machine6 = !A1machine6;
            }
            else if(i%5==0)
            {
                test.setObjectName("E1machine"+ String.valueOf(q));
                test.setStateName("MachineState");
                test.setStateValue(T1machine1 == true ? "Run" : "Down");
                T1machine1 = !T1machine1;
            }
            else
            {
                test.setObjectName("T1machine" + String.valueOf(q));
                test.setStateName("MachineState");
                test.setStateValue(T1machine1 == true ? "Run" : "Down");
                T1machine1 = !T1machine1;
            }
            messagingTemplate.convertAndSend("/topic/state",test);
        }
        return ResponseEntity.ok(stateDto);
    }


    @GetMapping
    public List<StateDto> getAllState(){
        return stateService.getAllState();
    }
}
