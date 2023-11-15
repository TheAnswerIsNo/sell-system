package com.wait.sellsystem.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wait.sellsystem.dao.RetailerMapper;
import com.wait.sellsystem.domain.entity.Retailer;
import com.wait.sellsystem.domain.param.retailer.RetailerAddParam;
import com.wait.sellsystem.domain.param.retailer.RetailerListParam;
import com.wait.sellsystem.domain.param.retailer.RetailerUpdateParam;
import com.wait.sellsystem.service.RetailerService;
import com.wait.sellsystem.utils.page.PageUtil;
import com.wait.sellsystem.utils.page.ResponseDTOWithPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @author 天
 * Time: 2023/11/16 1:49
 */
@Service
public class RetailerServiceImpl implements RetailerService {

    private final RetailerMapper retailerMapper;

    @Autowired
    public RetailerServiceImpl(RetailerMapper retailerMapper) {
        this.retailerMapper = retailerMapper;
    }

    @Override
    public ResponseDTOWithPage<Retailer> getList(RetailerListParam retailerListParam) {
        LambdaQueryWrapper<Retailer> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(Objects.nonNull(retailerListParam.getName()),Retailer::getName,retailerListParam.getName())
                    .like(Objects.nonNull(retailerListParam.getTelephone()),Retailer::getTelephone,retailerListParam.getTelephone())
                    .like(Objects.nonNull(retailerListParam.getAddress()),Retailer::getAddress,retailerListParam.getAddress())
                    .like(Objects.nonNull(retailerListParam.getCreateTime()),Retailer::getCreateTime,retailerListParam.getCreateTime())
                    .eq(Objects.nonNull(retailerListParam.getStatus()),Retailer::getStatus,retailerListParam.getStatus());
        PageUtil.startPage(retailerListParam, true, Retailer.class);
        List<Retailer> retailers = retailerMapper.selectList(queryWrapper);
        return PageUtil.getListDTO(retailers, retailerListParam);
    }

    @Override
    public Retailer findById(String id) {
        return retailerMapper.selectById(id);
    }

    @Override
    public int insert(RetailerAddParam retailerAddParam) {
        Retailer retailer = BeanUtil.copyProperties(retailerAddParam, Retailer.class);
        return retailerMapper.insert(retailer);
    }

    @Override
    public int delById(String id) {
        return retailerMapper.deleteById(id);
    }

    @Override
    public int updateById(RetailerUpdateParam retailerUpdateParam) {
        Retailer retailer = BeanUtil.copyProperties(retailerUpdateParam, Retailer.class);
        return retailerMapper.updateById(retailer);
    }


}
