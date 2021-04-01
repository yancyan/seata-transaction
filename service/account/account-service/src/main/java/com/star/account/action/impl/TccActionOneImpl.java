package com.star.account.action.impl;

import com.star.account.action.TccActionOne;
import io.seata.rm.tcc.api.BusinessActionContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service("tccActionOne")
public class TccActionOneImpl implements TccActionOne {


    @Override
    public boolean prepare(BusinessActionContext actionContext, Integer a) {
        String xid = actionContext.getXid();
        log.info("TccActionOne prepare, xid:" + xid);
        return true;
    }

    @Override
    public boolean commit(BusinessActionContext actionContext) {
        String xid = actionContext.getXid();
        log.info("TccActionOne commit, xid:" + xid);
        return true;
    }

    @Override
    public boolean rollback(BusinessActionContext actionContext) {
        String xid = actionContext.getXid();
        log.info("TccActionOne rollback, xid:" + xid);
        return true;
    }
}
