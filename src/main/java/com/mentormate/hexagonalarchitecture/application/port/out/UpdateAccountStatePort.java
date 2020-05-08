package com.mentormate.hexagonalarchitecture.application.port.out;

import com.mentormate.hexagonalarchitecture.domain.Account;

public interface UpdateAccountStatePort {

    void updateActivities(Account account);

}