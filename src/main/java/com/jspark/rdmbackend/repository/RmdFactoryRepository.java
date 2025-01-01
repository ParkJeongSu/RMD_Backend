package com.jspark.rdmbackend.repository;

import com.jspark.rdmbackend.entity.RmdFactory;
import com.jspark.rdmbackend.entity.Userprofile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RmdFactoryRepository extends JpaRepository<RmdFactory,Long> {
    void deleteByFactoryName(String factoryName);
}
