package com.orange.ilbun.security;

import com.orange.ilbun.security.CustomUserDetails;
import com.orange.ilbun.model.Member;
import com.orange.ilbun.repository.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private MemberMapper memberMapper;
    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {

        Member memberData = memberMapper.findByUserId(userId);

        if (memberData != null) {
            System.out.println("아이디를 찾았습니다.");
            return new CustomUserDetails(memberData);
        } else {
            throw new UsernameNotFoundException("해당 ID가 없습니다: " + userId);
        }
    }
}
