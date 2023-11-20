package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.urlRoute.Tech;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TechMapper extends BaseMapper<Tech> {
}
