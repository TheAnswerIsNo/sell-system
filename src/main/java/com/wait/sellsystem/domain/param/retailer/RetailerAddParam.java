package com.wait.sellsystem.domain.param.retailer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author 天
 * Time: 2023/11/16 2:10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RetailerAddParam {

    private String name;

    private String telephone;

    private String address;
}
