package com.springboot.shoppy.controller;

import com.springboot.shoppy.dto.Member;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
@CrossOrigin(origins = {"http://localhost:3000"})
public class MemberController {
    @PostMapping("/login")
    public boolean login(@RequestBody Member member) {
        System.out.println(member.getId());
        System.out.println(member.getPwd());

        boolean result = false;
        if(member.getId().equals("test") && member.getPwd().equals("1234")) result = true;

        return result;
    }
}
