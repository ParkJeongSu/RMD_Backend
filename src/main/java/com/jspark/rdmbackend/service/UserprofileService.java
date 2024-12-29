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

    public Optional<Userprofile> getUserprofileByUserName(String userName) {
        return userprofileRepository.findByUserName(userName);
    }

    public Userprofile createUserprofile(UserprofileDto userDto) {
        Userprofile user = new Userprofile();
        user.setUserName(userDto.getUserName());
        user.setPassword(userDto.getPassword());
        user.setUserType(userDto.getUserType());
        return userprofileRepository.save(user);
    }

    public boolean loginUserprofile(UserprofileDto userDto) {
        return this.getUserprofileByUserName(userDto.getUserName())
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
