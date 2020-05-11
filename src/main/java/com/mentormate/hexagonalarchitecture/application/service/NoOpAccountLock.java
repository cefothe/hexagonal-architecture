package com.mentormate.hexagonalarchitecture.application.service;

import com.mentormate.hexagonalarchitecture.application.port.out.AccountLock;
import com.mentormate.hexagonalarchitecture.domain.Account.AccountId;
import org.springframework.stereotype.Component;

@Component
class NoOpAccountLock implements AccountLock {

    @Override
    public void lockAccount(AccountId accountId) {
        // do nothing
    }

    @Override
    public void releaseAccount(AccountId accountId) {
        // do nothing
    }

}

