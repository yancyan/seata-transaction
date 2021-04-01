package com.star.account.dao;

import com.star.account.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ZhuYX
 * @date 2021/03/03
 */
public interface AccountRepository extends JpaRepository<Account, Long> {


}
