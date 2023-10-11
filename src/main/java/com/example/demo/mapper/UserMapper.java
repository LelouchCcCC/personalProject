package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.urlRoute.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface UserMapper extends BaseMapper<User> {
//    @Select("select * from User")
//    public List<User> find();
//
//    @Insert("insert into user values(#{name},#{passwd})")
//    public int charu(User user);
}
