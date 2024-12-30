package com.jspark.rdmbackend.service;
import com.jspark.rdmbackend.entity.Userprofile;
import com.jspark.rdmbackend.dto.UserprofileDto;
import com.jspark.rdmbackend.repository.UserprofileRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserprofileService {

    private final UserprofileRepository userprofileRepository;

    public UserprofileService(UserprofileRepository userRepository) {
        this.userprofileRepository = userRepository;
    }

    public List<Userprofile> getAllUsersprofile() {
        return userprofileRepository.findAll();
    }

    public Optional<Userprofile> getUserprofileByUserId(String userId){
        return userprofileRepository.findByUserId(userId);
    }

    public Optional<Userprofile> getUserprofileByUserName(String userName) {
        return userprofileRepository.findByUserName(userName);
    }

    public Userprofile createUserprofile(UserprofileDto userDto) {
        Userprofile user = new Userprofile();
        user.setUserId(userDto.getUserId());
        user.setUserName(userDto.getUserName());
        user.setUserGroupName(userDto.getUserGroupName());
        user.setPassword(userDto.getPassword());
        user.setDepartment(userDto.getDepartment());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setEmail(userDto.getEmail());
        user.setLocaleName(userDto.getLocaleName());
        user.setLastLoginTime(userDto.getLastLoginTime());
        user.setLastPasswordTime(userDto.getLastPasswordTime());
        user.setValidFlag(userDto.getValidFlag());
        user.setFmbDefaultFactoryName(userDto.getFmbDefaultFactoryName());
        user.setLastEventComment(userDto.getLastEventComment());
        return userprofileRepository.save(user);
    }

    public boolean loginUserprofile(UserprofileDto userDto) {
        return this.getUserprofileByUserId(userDto.getUserId())
                .map(user-> checkpassword(user.getPassword(),userDto.getPassword()))
                .orElse(false);
    }

    private boolean checkpassword(String userPasswordData, String sendPassword){
        return userPasswordData.equals(sendPassword);
    }

    public void deleteUserprofile(String userName) {
        userprofileRepository.deleteByUserName(userName);
    }
}
