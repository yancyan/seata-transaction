package com.star.account.domain;

import com.star.account.domain.enums.AccountType;
import com.star.config.common.domain.BaseModel;
import com.star.config.common.enums.Status;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author ZhuYX
 * @date 2021/03/03
 */
@Setter
@Getter
@ToString
@Entity
@Table(name = "Account")
public class Account extends BaseModel {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    private String code;

    @Column(name = "COMPANY_ID")
    private Long companyId;

    @Column(name = "CUSTOMER_ID")
    private Long customerId;

    private String mem;

    private String name;

    @Enumerated(EnumType.ORDINAL)
    private Status status;

    @Column(name = "TYPE")
    private AccountType type;

}
