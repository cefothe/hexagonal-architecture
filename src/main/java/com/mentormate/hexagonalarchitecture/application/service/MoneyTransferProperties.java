package com.mentormate.hexagonalarchitecture.application.service;

import com.mentormate.hexagonalarchitecture.domain.Money;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Configuration properties for money transfer use cases.
 */
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoneyTransferProperties {

    private Money maximumTransferThreshold = Money.of(1_000_000L);

}
