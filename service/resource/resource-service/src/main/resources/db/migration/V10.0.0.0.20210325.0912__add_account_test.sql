create table RESOURCE_TEST
(
    ID             NUMBER(10) not null,
    COMPANY_ID     NUMBER(10) ,

    AMOUNT         NUMBER(16, 2) default 0,
    LAST_AMOUNT    NUMBER(16, 2) default 0,
    STATUS         NUMBER(2) ,
    MEM            VARCHAR2(1024),

    version        NUMBER(10) default 1 not null,
    create_id      NUMBER(10),
    create_instant TIMESTAMP(6) WITH TIME ZONE default systimestamp not null,
    modify_id      NUMBER(10),
    modify_instant TIMESTAMP(6) WITH TIME ZONE default systimestamp not null,
    transaction_id VARCHAR2(100),
    server_name    VARCHAR2(100)
)
    tablespace ${table_space}
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
alter table RESOURCE_TEST
    add constraint PK_RESOURCE_TEST primary key (ID) using index
  tablespace ${table_space}
    pctfree 10
    initrans 2
    maxtrans 255
    storage
    (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
    );
CREATE SEQUENCE "SEQ_RESOURCE_TEST" MINVALUE 1 MAXVALUE 999999999 INCREMENT BY 1 START WITH 10000 CACHE 20 NOORDER  NOCYCLE;

