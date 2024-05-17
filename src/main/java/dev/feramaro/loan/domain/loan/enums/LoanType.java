package dev.feramaro.loan.domain.loan.enums;

import lombok.Getter;

@Getter
public enum LoanType {
    PERSONAL(4), GUARANTEED(3), CONSIGNMENT(2);

    private final int interestRate;

    LoanType(int interestRate) {
        this.interestRate = interestRate;
    }

}
