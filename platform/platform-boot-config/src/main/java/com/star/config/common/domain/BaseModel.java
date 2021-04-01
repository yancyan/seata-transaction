package com.star.config.common.domain;

import io.seata.core.context.RootContext;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

/**
 * @author ZhuYX
 * @date 2021/03/24
 */
@EntityListeners(BaseModel.AuditListener.class)
@MappedSuperclass
@Getter @Setter @ToString
public class BaseModel implements Serializable {
    private static final long serialVersionUID = 7198265667777602967L;

    @Version
    private int version;
    @Column(name = "CREATE_ID", updatable = false)
    private Long createId;
    @Column(name = "CREATE_INSTANT", updatable = false)
    private Instant createInstant;
    @Column(name = "MODIFY_ID")
    private Long modifyId;
    @Column(name = "MODIFY_INSTANT")
    private Instant modifyInstant;
    @Column(name = "TRANSACTION_ID")
    private String transactionId;
    @Column(name = "SERVER_NAME")
    private String serverName;


    static class AuditListener{
        @PrePersist
        public void touchForCreate(Object target) {
            if (target instanceof BaseModel) {
                BaseModel model = (BaseModel) target;
                Instant now = Instant.now();
                model.setCreateInstant(now);
                model.setModifyInstant(now);
                model.setCreateId(100L);
                model.setServerName("localhost");
                model.setVersion(1);
                model.setTransactionId(RootContext.getXID());
            }
        }

        @PreUpdate
        public void touchForUpdate(Object target) {
            if (target instanceof BaseModel) {
                BaseModel model = (BaseModel) target;
                model.setModifyInstant(Instant.now());
                model.setModifyId(101L);
                model.setServerName("localhost");
                model.setTransactionId(RootContext.getXID());
                model.setVersion(model.getVersion() + 1);
            }
        }
    }
}
