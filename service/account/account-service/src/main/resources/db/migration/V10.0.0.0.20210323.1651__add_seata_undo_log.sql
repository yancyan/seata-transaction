-- ################### ORACLE #####################
-- for AT mode you must to init this sql for you business database.
CREATE TABLE undo_log
(
    id            NUMBER(19)    NOT NULL,
    branch_id     NUMBER(19)    NOT NULL,
    xid           VARCHAR2(100) NOT NULL,
    context       VARCHAR2(128) NOT NULL,
    rollback_info BLOB          NOT NULL,
    log_status    NUMBER(10)    NOT NULL,
    log_created   TIMESTAMP(0)  NOT NULL,
    log_modified  TIMESTAMP(0)  NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT ux_undo_log UNIQUE (xid, branch_id)
) tablespace ${table_space}
    pctfree 10
    initrans 1
    maxtrans 255
    storage
(
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
);
-- Generate ID using sequence and trigger
CREATE SEQUENCE UNDO_LOG_SEQ START WITH 1 INCREMENT BY 1;