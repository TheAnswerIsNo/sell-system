package com.wait.sellsystem.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wait.sellsystem.dao.CommoditiesMapper;
import com.wait.sellsystem.domain.entity.Commodities;
import com.wait.sellsystem.domain.param.commodities.CommoditiesAddParam;
import com.wait.sellsystem.domain.param.commodities.CommoditiesListParam;
import com.wait.sellsystem.domain.param.commodities.CommoditiesUpdateParam;
import com.wait.sellsystem.service.AccessoryService;
import com.wait.sellsystem.service.CommoditiesService;
import com.wait.sellsystem.utils.page.PageUtil;
import com.wait.sellsystem.utils.page.ResponseDTOWithPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;


/**
 * @author 天
 * Time: 2023/11/16 2:22
 */
@Service
public class CommoditiesServiceImpl implements CommoditiesService {

    private final CommoditiesMapper commoditiesMapper;

    private final AccessoryService accessoryService;

    @Autowired
    public CommoditiesServiceImpl(CommoditiesMapper commoditiesMapper, AccessoryService accessoryService) {
        this.commoditiesMapper = commoditiesMapper;
        this.accessoryService = accessoryService;
    }

    @Override
    public ResponseDTOWithPage<Commodities> getList(CommoditiesListParam commoditiesListParam) {
        LambdaQueryWrapper<Commodities> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(Objects.nonNull(commoditiesListParam.getName()),Commodities::getName,commoditiesListParam.getName())
                .like(Objects.nonNull(commoditiesListParam.getLocality()),Commodities::getLocality,commoditiesListParam.getLocality())
                .ge(commoditiesListParam.getStartPrice() > 0,Commodities::getPrice,commoditiesListParam.getStartPrice())
                .le(commoditiesListParam.getEndPrice() > 0,Commodities::getPrice,commoditiesListParam.getEndPrice())
                .ge(Objects.nonNull(commoditiesListParam.getStartTime()),Commodities::getCreateTime,commoditiesListParam.getStartTime())
                .le(Objects.nonNull(commoditiesListParam.getEndTime()),Commodities::getCreateTime,commoditiesListParam.getEndTime());
        PageUtil.startPage(commoditiesListParam, true, Commodities.class);
        List<Commodities> commodities = commoditiesMapper.selectList(queryWrapper);
        return PageUtil.getListDTO(commodities, commoditiesListParam);
    }

    @Override
    public Commodities findById(String id) {
        return commoditiesMapper.selectById(id);
    }

    @Override
    public int insert(CommoditiesAddParam commoditiesAddParam) {
        Commodities commodities = BeanUtil.copyProperties(commoditiesAddParam, Commodities.class);
        return commoditiesMapper.insert(commodities);
    }

    @Override
    @Transactional
    public int delById(String id) {
        accessoryService.delByCommoditiesId(id);
        return commoditiesMapper.deleteById(id);
    }

    @Override
    public int updateById(CommoditiesUpdateParam commoditiesUpdateParam) {
        Commodities commodities = BeanUtil.copyProperties(commoditiesUpdateParam, Commodities.class);
        return commoditiesMapper.updateById(commodities);
    }
}
