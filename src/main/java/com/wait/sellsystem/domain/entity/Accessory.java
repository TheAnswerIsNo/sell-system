package com.wait.sellsystem.domain.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
* 附属品信息表
* @TableName accessory
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("accessory")
public class Accessory {

    /**
    * 附属品ID
    */
    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    /**
    * 商品ID
    */
    private String commoditiesId;

    /**
    * 附属品名称
    */
    private String name;

    /**
    * 价格
    */
    private String price;

    /**
    * 创建时间
    */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date createTime;
}
