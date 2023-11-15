package com.wait.sellsystem.domain.param.accessory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author 天
 * Time: 2023/11/16 3:07
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccessoryAddParam {

    private String commoditiesId;

    private String name;

    private String price;
}
