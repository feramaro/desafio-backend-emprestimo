package dev.feramaro.loan.domain.loan.DTOs;

import dev.feramaro.loan.domain.loan.enums.LoanType;

public record OfferDTO (LoanType type, Integer interest_rate) {

}


