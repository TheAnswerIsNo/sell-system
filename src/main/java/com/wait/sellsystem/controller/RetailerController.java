package com.wait.sellsystem.controller;

import cn.dev33.satoken.util.SaResult;
import com.wait.sellsystem.domain.entity.Retailer;
import com.wait.sellsystem.domain.param.retailer.RetailerAddParam;
import com.wait.sellsystem.domain.param.retailer.RetailerListParam;
import com.wait.sellsystem.domain.param.retailer.RetailerUpdateParam;
import com.wait.sellsystem.service.RetailerService;
import com.wait.sellsystem.utils.page.ResponseDTOWithPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author 天
 * Time: 2023/11/16 1:48
 */
@RestController
@RequestMapping(value = "/retailer")
@Api(tags = "零售商")
public class RetailerController {

    private final RetailerService retailerService;

    @Autowired
    public RetailerController(RetailerService retailerService) {
        this.retailerService = retailerService;
    }

    @ApiOperation("列表")
    @GetMapping(value = "/list")
    public SaResult getList(@RequestBody RetailerListParam retailerListParam){
        ResponseDTOWithPage<Retailer> result = retailerService.getList(retailerListParam);
        return new SaResult(SaResult.CODE_SUCCESS,"查询成功",result);
    }

    @ApiOperation("id查询")
    @GetMapping(value = "/detail/{id}")
    public SaResult findById(@PathVariable("id") String id){
        Retailer retailer = retailerService.findById(id);
        return new SaResult(SaResult.CODE_SUCCESS,"查询成功",retailer);
    }

    @ApiOperation("添加")
    @PostMapping(value = "/add")
    public SaResult insert(@RequestBody RetailerAddParam retailerAddParam){
        int result = retailerService.insert(retailerAddParam);
        if (result > 0){
            return SaResult.ok("添加成功");
        }
        return SaResult.error("添加失败");
    }

    @ApiOperation("删除")
    @PostMapping(value = "/del/{id}")
    public SaResult delById(@PathVariable("id") String id){
        int result = retailerService.delById(id);
        if (result > 0){
            return SaResult.ok("删除成功");
        }
        return SaResult.error("删除失败");
    }

    @ApiOperation("修改")
    @PostMapping(value = "/update")
    public SaResult updateById(@RequestBody RetailerUpdateParam retailerUpdateParam){
        int result = retailerService.updateById(retailerUpdateParam);
        if (result > 0){
            return SaResult.ok("修改成功");
        }
        return SaResult.error("修改失败");
    }

}
