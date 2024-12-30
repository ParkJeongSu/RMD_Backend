package com.jspark.rdmbackend.repository;
import com.jspark.rdmbackend.entity.Userprofile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserprofileRepository extends JpaRepository<Userprofile,Long> {
    Optional<Userprofile> findByUserName(String userName);
    Optional<Userprofile> findByUserId(String userId);
    void deleteByUserName(String userName);
}
