package com.example.practice.Controller;

import com.example.practice.Entity.MemberForm;
import com.example.practice.Service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class MemberController {
    private final MemberService memberService;
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        memberService.join(form);
        return "home";
    }
}
//
//    @GetMapping("/users/{id}")
//    public String getUser(@PathVariable Integer id) {
//        return "user id=" + id;
//    }
