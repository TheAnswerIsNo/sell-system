package com.wait.sellsystem.domain.param.commodities;

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
public class CommoditiesUpdateParam extends RequestDTOWithPage {

    private String name;

    private Double price;

    private Double locality;
}
