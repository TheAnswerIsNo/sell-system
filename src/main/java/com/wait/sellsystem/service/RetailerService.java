package com.wait.sellsystem.service;

import com.wait.sellsystem.domain.entity.Retailer;
import com.wait.sellsystem.domain.param.retailer.RetailerAddParam;
import com.wait.sellsystem.domain.param.retailer.RetailerListParam;
import com.wait.sellsystem.domain.param.retailer.RetailerUpdateParam;
import com.wait.sellsystem.utils.page.ResponseDTOWithPage;

/**
 * @author 天
 * Time: 2023/11/16 1:49
 */
public interface RetailerService {

    /**
     * 列表
     * @param retailerListParam
     * @return
     */
    ResponseDTOWithPage<Retailer> getList(RetailerListParam retailerListParam);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    Retailer findById(String id);

    /**
     * 添加
     * @param retailerAddParam
     * @return
     */
    int insert(RetailerAddParam retailerAddParam);

    /**
     * 删除
     * @param id
     * @return
     */
    int delById(String id);

    /**
     * 修改
     * @param retailerUpdateParam
     * @return
     */
    int updateById(RetailerUpdateParam retailerUpdateParam);
}
