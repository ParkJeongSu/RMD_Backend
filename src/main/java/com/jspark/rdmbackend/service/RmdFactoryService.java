package com.jspark.rdmbackend.service;


import com.jspark.rdmbackend.dto.RmdFactoryDto;
import com.jspark.rdmbackend.entity.RmdFactory;
import com.jspark.rdmbackend.repository.RmdFactoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RmdFactoryService {

    private final RmdFactoryRepository rmdFactoryRepository;

    public RmdFactoryService(RmdFactoryRepository rmdFactoryRepository) {
        this.rmdFactoryRepository = rmdFactoryRepository;
    }

    public List<RmdFactory> getAllRmdFactory() {
        return rmdFactoryRepository.findAll();
    }

    public RmdFactory createRmdFactory(String factoryName) {
        RmdFactory rmdFactory = new RmdFactory();
        rmdFactory.setFactoryName(factoryName);
        rmdFactory.setDefaultFactoryFlag("N");
        return rmdFactoryRepository.save(rmdFactory);
    }

    public boolean deleteRmdFactory(RmdFactoryDto rmdFactoryDto){
        try {
            rmdFactoryRepository.deleteByFactoryName(rmdFactoryDto.getFactoryName());
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    @Transactional
    public boolean updateRmdFactory(RmdFactoryDto rmdFactoryDto) {
        List<RmdFactory> rmdFactoryList = rmdFactoryRepository.findAll();

        try {
            rmdFactoryList
                    .forEach(
                            rmdFactory -> {
                                String defaultFlag = "N";
                                if(rmdFactory.getFactoryName().equals(rmdFactoryDto.getFactoryName()))
                                {
                                    defaultFlag = "Y";
                                }
                                else
                                {
                                    defaultFlag = "N";
                                }
                                rmdFactory.setDefaultFactoryFlag(defaultFlag);
                                rmdFactoryRepository.save(rmdFactory);
                            }
                    );

            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
}
