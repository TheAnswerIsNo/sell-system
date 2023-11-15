package com.wait.sellsystem.domain.dto.accessory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author 天
 * Time: 2023/11/16 2:51
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccessoryListDTO {

    private String name;

    private String price;

    private Date createTime;
}
