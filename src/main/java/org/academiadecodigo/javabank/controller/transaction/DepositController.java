package org.academiadecodigo.javabank.controller.transaction;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

/**
 * A controller used for deposit transactions
 * @see AbstractAccountTransactionController
 */
@Controller
@Profile("prod")
public class DepositController extends AbstractAccountTransactionController {

    /**
     * Deposits an amount on the account with the given id
     *
     * @see AbstractAccountTransactionController#submitTransaction(int, double)
     */
    @Override
    public void submitTransaction(int accountId, double amount) {
        accountService.deposit(accountId, amount);
    }
}
