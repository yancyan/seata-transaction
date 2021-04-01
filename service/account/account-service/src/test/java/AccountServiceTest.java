import com.star.account.AccountApplication;
import com.star.account.api.business.AccountService;
import com.star.account.domain.enums.AccountType;
import com.star.account.dto.AccountDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author ZhuYX
 * @date 2021/03/24
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {AccountApplication.class})
@ActiveProfiles("dev-f1")
public class AccountServiceTest {

    @Autowired
    private AccountService accountService;

    @Test
    public void test_save() {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setName("+ 1 ");
        accountDTO.setCustomerId(12222L);
        accountDTO.setType(AccountType.DEPOSIT);
        AccountDTO save = accountService.save(accountDTO);
        System.out.println(save);
    }
}
