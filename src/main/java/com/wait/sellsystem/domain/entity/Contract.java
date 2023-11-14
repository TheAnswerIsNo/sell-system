package com.wait.sellsystem.domain.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
* 采购合同表
* @TableName contract
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("contract")
public class Contract {

    /**
    * 合同ID
    */
    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    /**
    * 合同号
    */
    private String barcode;

    /**
    * 运输类型(1:省内,2:省外)
    */
    private Integer type;

    /**
    * 零售商ID
    */
    private String retailerId;

    /**
    * 创建时间
    */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date createTime;
}
