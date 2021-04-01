package com.star.account.domain;

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
@Setter @Getter @ToString
@Entity
@Table(name = "ACCOUNT_TEST")
public class AccountTest extends BaseModel {
    private static final long serialVersionUID = 6733410357880254465L;

    @Id
    @SequenceGenerator(name = "ORDER_TEST_ID_GENERATOR", sequenceName = "SEQ_ORDER_TEST", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "ORDER_TEST_ID_GENERATOR")
    private Long id;
    @Column(name = "COMPANY_ID")
    private Long companyId;
    @Column(name = "AMOUNT")
    private Double amount;
    @Column(name = "LAST_AMOUNT")
    private Double lastAmount;
    private String mem;
    private Status status;

}
