package com.star.order.api.business;


import com.star.order.action.TccActionOne;
import com.star.order.action.TccActionTwo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 注册TCC事务分支
 */
@Slf4j
@Service("tccFeignService")
public class TccFeignOrderServiceImpl implements TccFeignOrderService {

    @Autowired
    private TccActionOne tccActionOne;
    @Autowired
    private TccActionTwo tccActionTwo;

    @Override
    public boolean prepare_(Integer amount) {
        tccActionOne.prepare(null, 12);
        tccActionTwo.prepare(null, "sdf");

        log.info("TccFeignServiceImpl prepare exec");
        return false;
    }

}
