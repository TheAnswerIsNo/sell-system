package com.wait.sellsystem.domain.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
* 中间表
* @TableName middle_tab
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("middle_tab")
public class MiddleTab implements Serializable {

    /**
    * 中间表ID
    */
    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    /**
    * 合同ID
    */
    private String contractId;

    /**
    * 商品ID
    */
    private String commoditiesId;

    /**
    * 商品数量
    */
    private Integer number;
}
