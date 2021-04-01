package com.star.account.api.business;

import com.star.account.dao.AccountTestRepository;
import com.star.account.domain.AccountTest;
import com.star.account.dto.AccountTestDTO;
import com.star.config.common.util.BeanUtil;
import com.star.order.api.business.OrderTestService;
import com.star.resource.api.business.ResourceTestService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author ZhuYX
 * @date 2021/03/03
 */
@Slf4j
@Service("accountTestService")
public class AccountTestServiceImpl implements AccountTestService {

    @Autowired
    private AccountTestRepository accountTestRepository;

    @Autowired
    private OrderTestService orderTestService;
    @Autowired
    private ResourceTestService resourceTestService;

    @Override
    public AccountTestDTO save(AccountTestDTO accountDTO) {
        return null;
    }

    @GlobalTransactional
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public AccountTestDTO increment(Long id) {
        AtomicReference<AccountTestDTO> r = new AtomicReference<>();
        accountTestRepository.findById(id).ifPresent(rt -> {
            rt.setAmount(rt.getAmount() + 1);
            AccountTest save = accountTestRepository.save(rt);

            r.set(BeanUtil.copy(save, AccountTestDTO.class));
        });
        orderTestService.increment(id);
        return r.get();
    }

    @GlobalTransactional
    @Override
    public AccountTestDTO increment2(Long id) {
        AtomicReference<AccountTestDTO> r = new AtomicReference<>();
        accountTestRepository.findById(id).ifPresent(rt -> {
            rt.setAmount(rt.getAmount() + 1);
            AccountTest save = accountTestRepository.save(rt);

            r.set(BeanUtil.copy(save, AccountTestDTO.class));
        });
        orderTestService.increment(id);
        resourceTestService.increment(id);
        return r.get();
    }
}
