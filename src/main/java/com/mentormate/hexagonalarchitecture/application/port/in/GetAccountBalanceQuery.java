package com.mentormate.hexagonalarchitecture.application.port.in;

import com.mentormate.hexagonalarchitecture.domain.Account.AccountId;
import com.mentormate.hexagonalarchitecture.domain.Money;

public interface GetAccountBalanceQuery {

    Money getAccountBalance(AccountId accountId);

}