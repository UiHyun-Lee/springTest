package com.example.practice.Controller;

import com.example.practice.Entity.MemberForm;
import com.example.practice.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class MemberController {
    private final MemberService memberService;
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }


    @GetMapping("/")
    public String home(){
        return "home";
    }
    @GetMapping("/members/login")
    public String loginForm(){
        return "members/loginMemberForm";
    }

    @PostMapping("/members/login")
    public String login(MemberForm form, Model model) {
        MemberForm memberForm = memberService.login(form);
        if(!memberForm.getJwt().isEmpty()){
            model.addAttribute("memberform", memberForm.getJwt());
            return "home";
        }else{
            return "members/loginMemberForm";
        }
    }
//    @GetMapping("/members/new")
//    public String loginForm(){
//        return "createMemberForm";
//    }
//
//    @PostMapping("/members/new")
//    public String login(MemberForm form) {
//        memberService.join(form);
//        return "home";
//    }
//
}





//
//    @GetMapping("/users/{id}")
//    public String getUser(@PathVariable Integer id) {
//        return "user id=" + id;
//    }
