package com.star.account.dto;

import com.star.account.domain.enums.AccountType;
import com.star.config.common.enums.Status;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;

/**
 * @author ZhuYX
 * @date 2021/03/03
 */
@Getter
@Setter
@ToString
public class AccountDTO implements Serializable {

    private Long id;

    private String name;

    private String code;

    @Column(name = "COMPANY_ID")
    private Long companyId;
    @Column(name = "CUSTOMER_ID")
    private Long customerId;
    private String mem;
    @Enumerated(EnumType.ORDINAL)
    private Status status;
    @Column(name = "TYPE")
    private AccountType type;

}
