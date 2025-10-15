package com.springboot.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberRestController {
    @GetMapping("/restLogin")
    public String restLogin() {
        return "restLogin";
    }
}
