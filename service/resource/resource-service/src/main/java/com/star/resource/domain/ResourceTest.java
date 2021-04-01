package com.star.resource.domain;

import com.star.config.common.domain.BaseModel;
import com.star.config.common.enums.Status;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author ZhuYX
 * @date 2021/03/25
 */
@Getter @Setter @ToString
@Entity
@Table(name = "RESOURCE_TEST")
public class ResourceTest extends BaseModel {
    @Id
    @SequenceGenerator(name = "RESOURCE_TEST_ID_GENERATOR", sequenceName = "SEQ_RESOURCE_TEST", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "RESOURCE_TEST_ID_GENERATOR")
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
