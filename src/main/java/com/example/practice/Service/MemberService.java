package com.example.practice.Service;

import com.example.practice.Entity.Member;
import com.example.practice.Entity.MemberForm;
import com.example.practice.Repository.MemberRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

enum userAuth{
    ACTIVE("ACTIVE"), INACTIVE("INACTIVE");
    final private String auth;

    userAuth(String auth) {
        this.auth = auth;
    }
}

@Transactional
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    //    회원가입
    Long index = 0L;
    public Long join(MemberForm memberForm){

        Member member = new Member();

        member.setName(memberForm.getName());
        member.setNickname(memberForm.getNickname());
        member.setPassword(memberForm.getPassword());
        member.setEmail(memberForm.getEmail());
        member.setUserAuth(String.valueOf(userAuth.ACTIVE));

        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String formatedNow = now.format(formatter);
        member.setAppendDate(formatedNow);
        member.setUpdateDate(formatedNow);

        ValidateDuplicateMemberByEmail(member);
        ValidateDuplicateMemberByNickname(member);

        member.setId(createMemberId());
        member.setIndex(++index);
        memberRepository.save(member);
        return member.getId();
    }

    public Long createMemberId(){
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());
        Long id = ThreadLocalRandom.current().nextLong(Long.MAX_VALUE);
        while(true){
            if(memberRepository.findById(id).isEmpty()){
                return id;
            }else{
                id = random.nextLong();
            }
        }
    }

    private void ValidateDuplicateMemberByNickname(Member member) {//email 중복
        memberRepository.findByNickname(member.getNickname())
                .ifPresent(m -> {
                    throw new IllegalStateException("nickname exsists");
                });
    }

    private void ValidateDuplicateMemberByEmail(Member member) {//nickname 중복
        memberRepository.findByEmail(member.getEmail())
                .ifPresent(m -> {
                    throw new IllegalStateException("email exists");
                });
    }

}