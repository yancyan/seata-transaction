package com.star.order.api.business;

import com.star.config.common.util.BeanUtil;
import com.star.order.dao.OrderTestRepository;
import com.star.order.domain.OrderTest;
import com.star.order.dto.OrderTestDTO;
import com.star.resource.api.business.ResourceTestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author ZhuYX
 * @date 2021/03/03
 */
@Slf4j
@Service("orderTestService")
public class OrderTestServiceImpl implements OrderTestService {

    @Autowired
    private OrderTestRepository orderTestRepository;

    @Resource
    private ResourceTestService resourceTestService;

    @Override
    public OrderTestDTO save(OrderTestDTO rt) {
        return null;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public OrderTestDTO increment(Long id) {
        AtomicReference<OrderTestDTO> r = new AtomicReference<>();
        orderTestRepository.findById(id).ifPresent(rt -> {
            rt.setAmount(rt.getAmount() + 1);
            OrderTest save = orderTestRepository.save(rt);
            r.set(BeanUtil.copy(save, OrderTestDTO.class));
        });
//        resourceTestService.increment(id);
        return r.get();
    }
}
