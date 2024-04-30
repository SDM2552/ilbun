package com.orange.ilbun.service;

import com.orange.ilbun.model.Member;
import com.orange.ilbun.model.OrderList;
import com.orange.ilbun.repository.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    @Autowired
    private MemberMapper memberMapper;

    public List<OrderList> printOrderList(Long id){
        return memberMapper.selectAll(id);
    }
}
