package com.wait.sellsystem.domain.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
* 水果商品信息表
* @TableName commodities
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("commodities")
public class Commodities{

    /**
    * 商品ID
    */
    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    /**
    * 水果名称
    */
    private String name;

    /**
    * 价格
    */
    private Double price;

    /**
    * 产地
    */
    private String locality;

    /**
    * 录单时间
    */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date createTime;
}
