package com.wait.sellsystem.controller;

import cn.dev33.satoken.util.SaResult;
import com.wait.sellsystem.domain.dto.accessory.AccessoryListDTO;
import com.wait.sellsystem.domain.param.accessory.AccessoryAddParam;
import com.wait.sellsystem.domain.param.commodities.CommoditiesAddParam;
import com.wait.sellsystem.service.AccessoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * @author 天
 * Time: 2023/11/16 2:42
 */
@RestController
@RequestMapping(value = "/accessory")
@Api(tags = "附属品")
public class AccessoryController {

    private final AccessoryService accessoryService;

    @Autowired
    public AccessoryController(AccessoryService accessoryService) {
        this.accessoryService = accessoryService;
    }

    @ApiOperation("列表")
    @GetMapping(value = "/list/{commoditiesId}")
    public SaResult getListByCommoditiesId(@PathVariable("commoditiesId") String commoditiesId){
        List<AccessoryListDTO> result = accessoryService.getListByCommoditiesId(commoditiesId);
        return new SaResult(SaResult.CODE_SUCCESS,"查询成功",result);
    }

    @ApiOperation("批量删除")
    @PostMapping(value = "/list")
    public SaResult delBatch(@RequestBody List<String> accessoryIds){
        int result = accessoryService.delBatch(accessoryIds);
        if (result == accessoryIds.size()){
            return SaResult.ok("删除成功");
        }
        return SaResult.error("删除失败");
    }

    @ApiOperation("添加")
    @PostMapping(value = "/add")
    public SaResult insert(@RequestBody AccessoryAddParam accessoryAddParam){
        int result = accessoryService.insert(accessoryAddParam);
        if (result > 0){
            return SaResult.ok("添加成功");
        }
        return SaResult.error("添加失败");
    }


}
