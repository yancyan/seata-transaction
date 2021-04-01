package com.star.account.controller;

import com.star.account.api.business.AccountService;
import com.star.account.api.business.TccTransactionService;
import com.star.account.dto.AccountDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ZhuYX
 * @date 2021/03/05
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class AccountController {

    @Autowired
    private AccountService accountService;
    @Resource
    private TccTransactionService tccTransactionService;

    @GetMapping("findById")
    public AccountDTO findById(Long id) {
        return accountService.findById(id);
    }

    @GetMapping("test")
    public String test() {
        accountService.test();

        return "SUCCESS";
    }

    @GetMapping("tcc1")
    public String tcc() {
        accountService.prepareMinus("abc", 12D);
        return "SUCCESS";
    }

    @GetMapping("tcc2")
    public String tcc2() {
        log.info("test tcc2...");
        return tccTransactionService.test("abc", 23D);
    }

    @GetMapping("save")
    public String save() {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setName("+ 1 ");
        AccountDTO save = accountService.save(accountDTO);
        return save.toString();
    }
}
