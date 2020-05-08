package com.mentormate.hexagonalarchitecture.application.port.in;

import com.mentormate.hexagonalarchitecture.common.SelfValidating;
import com.mentormate.hexagonalarchitecture.domain.Account;
import com.mentormate.hexagonalarchitecture.domain.Account.AccountId;
import com.mentormate.hexagonalarchitecture.domain.Money;
import javax.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Value;

public interface SendMoneyUseCase {

    boolean sendMoney(SendMoneyCommand command);

    @Value
    @EqualsAndHashCode(callSuper = false)
    class SendMoneyCommand extends SelfValidating<SendMoneyCommand> {

        @NotNull
        private final Account.AccountId sourceAccountId;

        @NotNull
        private final Account.AccountId targetAccountId;

        @NotNull
        private final Money money;

        public SendMoneyCommand(
            AccountId sourceAccountId,
            AccountId targetAccountId,
            Money money) {
            this.sourceAccountId = sourceAccountId;
            this.targetAccountId = targetAccountId;
            this.money = money;
            this.validateSelf();
        }
    }

}