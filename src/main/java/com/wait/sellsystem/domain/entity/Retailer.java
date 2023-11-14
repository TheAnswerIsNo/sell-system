package com.wait.sellsystem.domain.entity;


import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
* 零售商信息表
* @TableName retailer
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("retailer")
public class Retailer {

    /**
    * 零售商ID
    */
    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    /**
    * 零售商姓名
    */
    private String name;

    /**
    * 零售商电话
    */
    private String telephone;

    /**
    * 零售商地址
    */
    private String address;

    /**
    * 状态(0:停用,1:启用)
    */
    private Integer status;

    /**
    * 创建时间
    */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date createTime;
}
