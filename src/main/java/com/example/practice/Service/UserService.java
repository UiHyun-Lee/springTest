package com.example.practice.Service;

import com.example.practice.Entity.Users;
import com.example.practice.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<Users> getUsersService(String name){
        if(name.isBlank()) // name 파라미터가 Null이면 전체 user를 리턴
            return userRepository.findAll();
        else  // name 이 존재를 하면, Like 쿼리로 2개만 리턴
            return userRepository.findFirst2ByUsernameLikeOrderByIDDesc(name);
    }

    public String createUserService(Users user){
        userRepository.save(user); // User Insert 쿼리 수행
        return "등록 완료";
    }
}