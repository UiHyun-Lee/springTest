package com.example.practice;

import com.example.practice.Entity.Users;
import com.example.practice.Repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
//import lombok.extern.slf4j.Slf4j;
import java.util.List;

import static java.sql.DriverManager.println;

@SpringBootTest
@DataJpaTest
//@Slf4j
class PracticeApplicationTests {
//
//    @Autowired
//    UserRepository userRepository;
//
//    @BeforeEach
//    void insertTestData() {
//        Users user = new Users();
//        user.setUsername("kim ori");
//        userRepository.save(user);
//
//        user = new Users();
//        user.setUsername("lee ori");
//        userRepository.save(user);
//
//        user = new Users();
//        user.setUsername("kim ental");
//        userRepository.save(user);
//
//        user = new Users();
//        user.setUsername("lee ental");
//        userRepository.save(user);
//
//        user = new Users();
//        user.setUsername("kim samuel");
//        userRepository.save(user);
//    }
//
//    @Test
//    void findAllTest() { // 저장된 데이터 모두를 Spring JPA에 미리 구현된 findAll 명령을 통해 불러온다
//        List<Users> userList = userRepository.findAll();
//        for(Users u : userList) println("[FindAll]: " + u.getID() + " | " +u.getUsername());
//    }
//
//    @Test
//    void find2ByNameTest() { // Like 검색으로 2개만 값을 가져오는 내가 작성한 명령을 실행해본다
//        List<Users> userList = userRepository.findFirst2ByUsernameLikeOrderByIDDesc("kim%");
//        for(Users u : userList) println("[FindSome]: "  + u.getID() + " | " +u.getUsername());
//    }

}
