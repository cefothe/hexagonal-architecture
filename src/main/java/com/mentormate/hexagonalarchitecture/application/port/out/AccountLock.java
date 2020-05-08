package com.mentormate.hexagonalarchitecture.application.port.out;

import com.mentormate.hexagonalarchitecture.domain.Account;

public interface AccountLock {

    void lockAccount(Account.AccountId accountId);

    void releaseAccount(Account.AccountId accountId);

}