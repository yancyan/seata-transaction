package com.star.order.action.impl;


import com.star.order.action.ResultHolder;
import com.star.order.action.TccActionOne;
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
        ResultHolder.setActionOneResult(xid, "T");
        return true;
    }

    @Override
    public boolean rollback(BusinessActionContext actionContext) {
        String xid = actionContext.getXid();
        log.info("TccActionOne rollback, xid:" + xid);
        ResultHolder.setActionOneResult(xid, "R");
        return true;
    }
}
