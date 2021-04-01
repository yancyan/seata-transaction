package com.star.account.controller;

import com.star.account.api.business.AccountTestService;
import com.star.account.dto.AccountTestDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZhuYX
 * @date 2021/03/05
 */
@Slf4j
@RestController
@RequestMapping("/at")
public class ATController {

    @Autowired
    private AccountTestService accountTestService;

    @GetMapping("incre")
    public String save() {
        AccountTestDTO increment = accountTestService.increment(10000L);
        return increment.toString();
    }

    @GetMapping("incre2")
    public String save2() {
        AccountTestDTO increment = accountTestService.increment2(10000L);
        return increment.toString();
    }
}
