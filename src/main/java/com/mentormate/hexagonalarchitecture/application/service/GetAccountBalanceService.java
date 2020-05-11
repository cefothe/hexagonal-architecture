package com.mentormate.hexagonalarchitecture.application.service;

import com.mentormate.hexagonalarchitecture.application.port.in.GetAccountBalanceQuery;
import com.mentormate.hexagonalarchitecture.application.port.out.LoadAccountPort;
import com.mentormate.hexagonalarchitecture.domain.Account.AccountId;
import com.mentormate.hexagonalarchitecture.domain.Money;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class GetAccountBalanceService implements GetAccountBalanceQuery {

    private final LoadAccountPort loadAccountPort;

    @Override
    public Money getAccountBalance(AccountId accountId) {
        return loadAccountPort.loadAccount(accountId, LocalDateTime.now())
            .calculateBalance();
    }
}
