package com.orange.ilbun.repository;

import com.orange.ilbun.model.Member;
import com.orange.ilbun.model.OrderList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MemberMapper {

    @Select("select count(*) from member")
    int count();
    boolean existsByUserId(String userId);
    void insertUser(Member member);

    @Select("select * from member where user_id=#{userId}")
    Member findByUserId(String userId);

    @Select("SELECT * FROM order_info oi INNER JOIN order_item oitem ON oi.order_id = oitem.order_id where oi.user_id=#{id}")
    List<OrderList> selectAll(Long id);



}
