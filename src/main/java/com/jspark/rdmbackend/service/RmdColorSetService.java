package com.jspark.rdmbackend.service;


import com.jspark.rdmbackend.dto.RmdColorSetDto;
import com.jspark.rdmbackend.dto.RmdFactoryDto;
import com.jspark.rdmbackend.entity.RmdColorSet;
import com.jspark.rdmbackend.entity.RmdColorSetKey;
import com.jspark.rdmbackend.entity.RmdFactory;
import com.jspark.rdmbackend.repository.RmdColorSetRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class RmdColorSetService {

    private final RmdColorSetRepository rmdColorSetRepository;

    public RmdColorSetService(RmdColorSetRepository rmdColorSetRepository){
        this.rmdColorSetRepository = rmdColorSetRepository;
    }

    public List<RmdColorSetDto> getAllRmdColorSet() {
        List<RmdColorSet> rmdColorSetList = rmdColorSetRepository.findAll();
        rmdColorSetList.sort(Comparator.comparing((RmdColorSet r) -> r.getKey().getTypeName()));

        List<RmdColorSetDto> rmdColorSetDtoList = new ArrayList<>();

        rmdColorSetList.stream().forEach(data ->{
            RmdColorSetDto dto = new RmdColorSetDto();
            dto.setTypeName(data.getKey().getTypeName());
            dto.setStateName(data.getKey().getStateName());
            dto.setStateValue(data.getKey().getStateValue());
            dto.setTypeAttribute(data.getKey().getTypeAttribute());
            dto.setTypeAttributeValue(data.getTypeAttributeValue());
            rmdColorSetDtoList.add(dto);
        });

        return rmdColorSetDtoList;
    }

    public RmdColorSet createRmdColorSet(RmdColorSetDto rmdColorSetDto) {
        RmdColorSetKey key = new RmdColorSetKey();
        key.setTypeName(rmdColorSetDto.getTypeName());
        key.setStateName(rmdColorSetDto.getStateName());
        key.setStateValue(rmdColorSetDto.getStateValue());
        key.setTypeAttribute(rmdColorSetDto.getTypeAttribute());
        RmdColorSet rmdColorSet = new RmdColorSet();
        rmdColorSet.setKey(key);
        rmdColorSet.setTypeAttributeValue(rmdColorSet.getTypeAttributeValue());
        return rmdColorSetRepository.save(rmdColorSet);
    }

    public RmdColorSet updateRmdColorSet(RmdColorSetDto rmdColorSetDto)
    {
        RmdColorSetKey key = new RmdColorSetKey();
        key.setTypeName(rmdColorSetDto.getTypeName());
        key.setStateName(rmdColorSetDto.getStateName());
        key.setStateValue(rmdColorSetDto.getStateValue());
        key.setTypeAttribute(rmdColorSetDto.getTypeAttributeValue());
        Optional<RmdColorSet> rmdColorSetDataById = rmdColorSetRepository.findById(key);
        RmdColorSet rmdColorSet = rmdColorSetDataById.map(data -> {
                    data.setTypeAttributeValue(rmdColorSetDto.getTypeAttributeValue());
                    return data;
                    }).orElseThrow(()-> new RuntimeException("RmdColorSet not found"));
        return rmdColorSetRepository.save(rmdColorSet);
    }

    public boolean deleteRmdFactory(RmdColorSetDto rmdColorSetDto){
        try {
            RmdColorSetKey key = new RmdColorSetKey();
            key.setTypeName(rmdColorSetDto.getTypeName());
            key.setStateName(rmdColorSetDto.getStateName());
            if(rmdColorSetRepository.existsById(key))
            {
                rmdColorSetRepository.deleteById(key);
            }
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
}
