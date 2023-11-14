package com.wait.sellsystem.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wait.sellsystem.domain.entity.Commodities;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 天
* @description 针对表【commodities(水果商品信息表)】的数据库操作Mapper
* @createDate 2023-11-15 03:44:18
* @Entity com.wait.sellsystem.domain.entity.Commodities
*/
@Mapper
public interface CommoditiesMapper extends BaseMapper<Commodities> {

}




