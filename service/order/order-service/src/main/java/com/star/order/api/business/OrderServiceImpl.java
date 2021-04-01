package com.star.order.api.business;

import com.star.resource.api.business.ResourceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ZhuYX
 * @date 2021/03/03
 */
@Slf4j
@Service("orderService")
public class OrderServiceImpl implements OrderService{

    @Autowired
    private ResourceService resourceService;

    @Override
    public void test() {
        log.info("OrderServiceImpl test exec.");
        resourceService.test();
    }
}
