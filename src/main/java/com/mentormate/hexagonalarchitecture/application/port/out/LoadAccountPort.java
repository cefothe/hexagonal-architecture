package com.mentormate.hexagonalarchitecture.application.port.out;

import com.mentormate.hexagonalarchitecture.domain.Account;
import com.mentormate.hexagonalarchitecture.domain.Account.AccountId;
import java.time.LocalDateTime;

public interface LoadAccountPort {

    Account loadAccount(AccountId accountId, LocalDateTime baselineDate);
}