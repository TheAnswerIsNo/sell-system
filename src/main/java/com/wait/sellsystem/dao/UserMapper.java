package com.wait.sellsystem.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wait.sellsystem.domain.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 天
* @description 针对表【user(用户表)】的数据库操作Mapper
* @createDate 2023-11-15 03:44:19
* @Entity com.wait.sellsystem.domain.entity.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

}




