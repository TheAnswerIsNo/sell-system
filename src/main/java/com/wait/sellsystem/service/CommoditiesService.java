package com.wait.sellsystem.service;

import com.wait.sellsystem.domain.entity.Commodities;
import com.wait.sellsystem.domain.param.commodities.CommoditiesAddParam;
import com.wait.sellsystem.domain.param.commodities.CommoditiesListParam;
import com.wait.sellsystem.domain.param.commodities.CommoditiesUpdateParam;
import com.wait.sellsystem.utils.page.ResponseDTOWithPage;

/**
 * @author 天
 * Time: 2023/11/16 2:22
 */
public interface CommoditiesService {

    /**
     * 列表
     * @param commoditiesListParam
     * @return
     */
    ResponseDTOWithPage<Commodities> getList(CommoditiesListParam commoditiesListParam);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    Commodities findById(String id);

    /**
     * 根据id删除
     * @param id
     * @return
     */
    int delById(String id);

    /**
     * 添加
     * @param commoditiesAddParam
     * @return
     */
    int insert(CommoditiesAddParam commoditiesAddParam);

    /**
     * 根据id修改
     * @param commoditiesUpdateParam
     * @return
     */
    int updateById(CommoditiesUpdateParam commoditiesUpdateParam);
}
