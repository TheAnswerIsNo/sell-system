package com.wait.sellsystem.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.wait.sellsystem.dao.AccessoryMapper;
import com.wait.sellsystem.domain.dto.accessory.AccessoryListDTO;
import com.wait.sellsystem.domain.entity.Accessory;
import com.wait.sellsystem.domain.param.accessory.AccessoryAddParam;
import com.wait.sellsystem.service.AccessoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


/**
 * @author 天
 * Time: 2023/11/16 2:48
 */
@Service
public class AccessoryServiceImpl implements AccessoryService {

    private final AccessoryMapper accessoryMapper;

    @Autowired
    public AccessoryServiceImpl(AccessoryMapper accessoryMapper) {
        this.accessoryMapper = accessoryMapper;
    }

    @Override
    public List<AccessoryListDTO> getListByCommoditiesId(String commoditiesId) {
        LambdaQueryWrapper<Accessory> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Accessory::getCommoditiesId,commoditiesId);
        List<Accessory> accessories = accessoryMapper.selectList(queryWrapper);
        return accessories.stream()
                .map(accessory ->BeanUtil.copyProperties(accessory, AccessoryListDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public int delBatch(List<String> accessoryIds) {
        return accessoryMapper.deleteBatchIds(accessoryIds);
    }

    @Override
    public int delByCommoditiesId(String commoditiesId) {
        LambdaUpdateWrapper<Accessory> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(Accessory::getCommoditiesId,commoditiesId);
        return accessoryMapper.delete(updateWrapper);
    }

    @Override
    public int insert(AccessoryAddParam accessoryAddParam) {
        Accessory accessory = BeanUtil.copyProperties(accessoryAddParam, Accessory.class);
        return accessoryMapper.insert(accessory);
    }
}
