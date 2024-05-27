package com.example.practice.Repository;

import com.example.practice.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    List<Users> findFirst2ByUsernameLikeOrderByIDDesc(String name);

}