package com.example.practice.Repository;

import com.example.practice.Entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Object> findByNickname(String nickname);
    Optional<Object> findByEmail(String email);
}