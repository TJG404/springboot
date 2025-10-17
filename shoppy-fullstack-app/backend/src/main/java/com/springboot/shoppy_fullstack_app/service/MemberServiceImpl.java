package com.springboot.shoppy_fullstack_app.service;

import com.springboot.shoppy_fullstack_app.dto.Member;
import com.springboot.shoppy_fullstack_app.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
//@Transactional : DB가 auto-commit 모드이면 생략가능
public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder; // 주입된 BCryptPasswordEncoder

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository, PasswordEncoder passwordEncoder) {
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public int signup(Member member){
        // 1. DTO에서 비밀번호를 가져옴
//        String rawPwd = member.getPwd();

        // 2. 🚨 passwordEncoder.encode()를 사용하여 비밀번호를 암호화(해싱)
//        String encodedPwd = passwordEncoder.encode(member.getPwd());
//        System.out.println(" encode  pwd ==>" + encodedPwd);
        // 3. 암호화된 비밀번호를 User 엔티티에 설정
//        User newUser = new User(userDto.getUsername(), encodedPassword);
//            member.setPwd(encodedPwd);
//        System.out.println(" member.getPwd() ==>" + member.getPwd());
//
//        // 4. DB에 저장
//        return userRepository.save(newUser);
//    }
        return memberRepository.save(member);
    }

    @Override
    public boolean idCheck(String id) {
        boolean result = true;
        Long count = memberRepository.findById(id);
        if(count == 0) result = false;
        return result;
    }

}
