package com.star.account.api.business;

import com.star.account.action.TccActionOne;
import com.star.account.action.TccActionTwo;
import com.star.order.api.business.TccFeignOrderService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 注册TCC事务分支
 */
@Service("tccTransactionService")
public class TccTransactionServiceImpl implements TccTransactionService{

    @Autowired
    private TccActionOne tccActionOne;
    @Autowired
    private TccActionTwo tccActionTwo;
    @Autowired
    TccFeignOrderService tccFeignOrderService;

    @GlobalTransactional
    @Override
    public String test(String accountNo, Double amount) {
        tccActionOne.prepare(null, 22);
        tccActionTwo.prepare(null, "33");
        tccFeignOrderService.prepare_(23);
        return RootContext.getXID() + RootContext.getBranchType();
    }
}
