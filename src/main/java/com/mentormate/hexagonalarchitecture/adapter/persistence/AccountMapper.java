package com.mentormate.hexagonalarchitecture.adapter.persistence;

import com.mentormate.hexagonalarchitecture.domain.Account;
import com.mentormate.hexagonalarchitecture.domain.Account.AccountId;
import com.mentormate.hexagonalarchitecture.domain.Activity;
import com.mentormate.hexagonalarchitecture.domain.Activity.ActivityId;
import com.mentormate.hexagonalarchitecture.domain.ActivityWindow;
import com.mentormate.hexagonalarchitecture.domain.Money;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
class AccountMapper {

	Account mapToDomainEntity(
			AccountJpaEntity account,
			List<ActivityJpaEntity> activities,
			Long withdrawalBalance,
			Long depositBalance) {

		Money baselineBalance = Money.subtract(
				Money.of(depositBalance),
				Money.of(withdrawalBalance));

		return Account.withId(
				new AccountId(account.getId()),
				baselineBalance,
				mapToActivityWindow(activities));

	}

	ActivityWindow mapToActivityWindow(List<ActivityJpaEntity> activities) {
		List<Activity> mappedActivities = new ArrayList<>();

		for (ActivityJpaEntity activity : activities) {
			mappedActivities.add(new Activity(
					new ActivityId(activity.getId()),
					new AccountId(activity.getOwnerAccountId()),
					new AccountId(activity.getSourceAccountId()),
					new AccountId(activity.getTargetAccountId()),
					activity.getTimestamp(),
					Money.of(activity.getAmount())));
		}

		return new ActivityWindow(mappedActivities);
	}

	ActivityJpaEntity mapToJpaEntity(Activity activity) {
		return new ActivityJpaEntity(
				activity.getId() == null ? null : activity.getId().getValue(),
				activity.getTimestamp(),
				activity.getOwnerAccountId().getValue(),
				activity.getSourceAccountId().getValue(),
				activity.getTargetAccountId().getValue(),
				activity.getMoney().getAmount().longValue());
	}
}
