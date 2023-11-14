package com.wait.sellsystem.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wait.sellsystem.domain.entity.Accessory;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 天
* @description 针对表【accessory(附属品信息表)】的数据库操作Mapper
* @createDate 2023-11-15 03:44:18
* @Entity com.wait.sellsystem.domain.entity.Accessory
*/
@Mapper
public interface AccessoryMapper extends BaseMapper<Accessory> {

}




