package com.wait.sellsystem.service;

import com.wait.sellsystem.domain.dto.accessory.AccessoryListDTO;
import com.wait.sellsystem.domain.param.accessory.AccessoryAddParam;

import java.util.List;

/**
 * @author 天
 * Time: 2023/11/16 2:48
 */
public interface AccessoryService {

    /**
     * 根据商品id获取列表
     * @param commoditiesId
     * @return
     */
    List<AccessoryListDTO> getListByCommoditiesId(String commoditiesId);

    /**
     * 批量删除
     * @param accessoryIds
     * @return
     */
    int delBatch(List<String> accessoryIds);

    /**
     * 根据商品id删除
     * @param commoditiesId
     * @return
     */
    int delByCommoditiesId(String commoditiesId);

    /**
     * 添加
     * @param accessoryAddParam
     * @return
     */
    int insert(AccessoryAddParam accessoryAddParam);
}
