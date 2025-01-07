package com.jspark.rdmbackend;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.jspark.rdmbackend.entity.Userprofile;
import com.jspark.rdmbackend.repository.UserprofileRepository;
import com.jspark.rdmbackend.service.UserprofileService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

public class MockitoTests {

    @Mock
    private  UserprofileRepository userprofileRepository;

    @InjectMocks
    private UserprofileService userprofileService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);  // Mock 초기화
    }

    @Test
    public void testGetOrderById_Success() {
        // 가짜 Order 객체 생성
        Userprofile user = new Userprofile();
        user.setUserId("test");
        Optional<Userprofile> userprofile = Optional.of(user);

        when(userprofileRepository.findByUserId("test")).thenReturn(userprofile);

        Optional<Userprofile> testUserProfile = userprofileService.getUserprofileByUserId("test");

        // 검증
        testUserProfile.ifPresent(value -> assertEquals("test", value.getUserId()));

    }

}
