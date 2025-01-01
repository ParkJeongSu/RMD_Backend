package com.jspark.rdmbackend.repository;

import com.jspark.rdmbackend.entity.RmdColorSet;
import com.jspark.rdmbackend.entity.RmdColorSetKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RmdColorSetRepository extends JpaRepository<RmdColorSet, RmdColorSetKey> {
}
