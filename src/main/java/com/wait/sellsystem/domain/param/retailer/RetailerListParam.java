package com.wait.sellsystem.domain.param.retailer;

import com.wait.sellsystem.utils.page.RequestDTOWithPage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 天
 * Time: 2023/11/16 1:56
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RetailerListParam extends RequestDTOWithPage {

    private String name;

    private String telephone;

    private String address;

    private Integer status;

    private String createTime;
}
