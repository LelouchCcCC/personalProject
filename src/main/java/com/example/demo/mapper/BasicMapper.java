package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.urlRoute.Basic;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BasicMapper extends BaseMapper<Basic> {
    @Select("select * from basic where name=#{name}")
    public Basic queryByName(@Param("name") String name);
}
