package com.orange.ilbun.repository;

import com.orange.ilbun.model.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MemberMapper {

    @Select("select count(*) from member")
    int count();
    boolean existsByUserId(String userId);
    void insertUser(Member member);

    @Select("select * from member where user_id=#{userId}")
    Member findByUserId(String userId);
}
