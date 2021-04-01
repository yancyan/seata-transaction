package com.star.config.common.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.Instant;

/**
 * @author ZhuYX
 * @date 2021/03/25
 */
@Setter @Getter @ToString
public class AbstractDTO implements Serializable {

    private static final long serialVersionUID = -3338037983543240227L;

    private Long id;
    private int version;
    private Long createId;
    private Instant createInstant;
    private Long modifyId;
    private Instant modifyInstant;
    private String transactionId;
//    private String serverName;


}
