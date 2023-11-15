package com.wait.sellsystem.controller;

import cn.dev33.satoken.util.SaResult;
import com.wait.sellsystem.domain.entity.Commodities;
import com.wait.sellsystem.domain.param.commodities.CommoditiesAddParam;
import com.wait.sellsystem.domain.param.commodities.CommoditiesListParam;
import com.wait.sellsystem.domain.param.commodities.CommoditiesUpdateParam;
import com.wait.sellsystem.service.CommoditiesService;
import com.wait.sellsystem.utils.page.ResponseDTOWithPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author 天
 * Time: 2023/11/16 2:21
 */
@RestController
@RequestMapping(value = "/commodities")
@Api(tags = "商品")
public class CommoditiesController {

    private final CommoditiesService commoditiesService;

    @Autowired
    public CommoditiesController(CommoditiesService commoditiesService) {
        this.commoditiesService = commoditiesService;
    }

    @ApiOperation("列表")
    @GetMapping(value = "/list")
    public SaResult getList(@RequestBody CommoditiesListParam commoditiesListParam){
        ResponseDTOWithPage<Commodities> result = commoditiesService.getList(commoditiesListParam);
        return new SaResult(SaResult.CODE_SUCCESS,"查询成功",result);
    }

    @ApiOperation("id查询")
    @GetMapping(value = "/detail/{id}")
    public SaResult findById(@PathVariable("id") String id){
        Commodities commodities = commoditiesService.findById(id);
        return new SaResult(SaResult.CODE_SUCCESS,"查询成功",commodities);
    }

    @ApiOperation("添加")
    @PostMapping(value = "/add")
    public SaResult insert(@RequestBody CommoditiesAddParam commoditiesAddParam){
        int result = commoditiesService.insert(commoditiesAddParam);
        if (result > 0){
            return SaResult.ok("添加成功");
        }
        return SaResult.error("添加失败");
    }

    @ApiOperation("删除")
    @PostMapping(value = "/del/{id}")
    public SaResult delById(@PathVariable("id") String id){
        int result = commoditiesService.delById(id);
        if (result > 0){
            return SaResult.ok("删除成功");
        }
        return SaResult.error("删除失败");
    }

    @ApiOperation("修改")
    @PostMapping(value = "/update")
    public SaResult updateById(@RequestBody CommoditiesUpdateParam commoditiesUpdateParam){
        int result = commoditiesService.updateById(commoditiesUpdateParam);
        if (result > 0){
            return SaResult.ok("修改成功");
        }
        return SaResult.error("修改失败");
    }
}
