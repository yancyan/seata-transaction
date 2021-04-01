package com.star.account.api.business;

import com.star.account.dao.AccountRepository;
import com.star.account.domain.Account;
import com.star.account.dto.AccountDTO;
import com.star.config.common.util.BeanUtil;
import com.star.order.api.business.OrderService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author ZhuYX
 * @date 2021/03/03
 */
@Slf4j
@Service("accountService")
public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private OrderService orderService;
    @Resource
    private AccountServiceImpl accountService;

    public static final AtomicLong id = new AtomicLong(20161153);

    @Transactional
    @Override
    public AccountDTO save(AccountDTO accountDTO) {
        Account account = BeanUtil.copy(accountDTO, Account.class);
        account.setId(id.getAndAdd(1));
        Account save = accountRepository.save(account);
        return BeanUtil.copy(save, AccountDTO.class);
    }

    @Override
    public AccountDTO findById(Long id) {
        Account account = accountRepository.findById(id).orElse(null);
        if (account == null) {
            return null;
        }
        AccountDTO re = new AccountDTO();
        re.setId(id);
        re.setName("findById...");
        BeanUtils.copyProperties(account, re);
        return re;
    }

    @Override
    public void test() {
        log.info("AccountServiceImpl test exec.");
        orderService.test();
    }

    @GlobalTransactional
    @Override
    public boolean prepareMinus(String accountNo, Double amount) {
        return false;
    }

}
