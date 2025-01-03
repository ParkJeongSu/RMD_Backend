package com.jspark.rdmbackend.service;

import com.jspark.rdmbackend.dto.StateDto;
import com.jspark.rdmbackend.repository.StateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateService {

    private final StateRepository stateRepository;

    public StateService(StateRepository stateRepository){
        this.stateRepository = stateRepository;
    }

    public List<StateDto> getAllState() {
        return stateRepository.findAllState();
    }

}
