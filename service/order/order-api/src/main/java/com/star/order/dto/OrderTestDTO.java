package com.star.order.dto;

import com.star.config.common.dto.AbstractDTO;
import com.star.config.common.enums.Status;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author ZhuYX
 * @date 2021/03/25
 */
@Getter
@Setter
@ToString
public class OrderTestDTO extends AbstractDTO {


    private Long companyId;
    private Double amount;
    private Double lastAmount;
    private String mem;
    private Status status;
}
