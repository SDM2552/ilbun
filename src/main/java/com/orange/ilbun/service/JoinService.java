package com.orange.ilbun.service;

import com.orange.ilbun.model.Member;
import com.orange.ilbun.repository.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JoinService {

    @Autowired
    private MemberMapper memberMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public void joinProcess(Member member) {

        String userId = member.getUserId();
        String password = member.getPassword();
        boolean isExist = memberMapper.existsByUserId(userId);

        if (isExist) {
            System.out.println("이미 가입된 ID");
            return;
        }
        String encryptedPassword = passwordEncoder.encode(password);

        member.setPassword(encryptedPassword);
        System.out.println("멤버 가입 정보: "+member.toString());
        memberMapper.insertUser(member);
        System.out.println("회원가입 성공");
    }

}
