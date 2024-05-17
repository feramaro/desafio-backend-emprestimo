package dev.feramaro.loan.domain.loan.DTOs;

import java.util.Set;

public record LoanDTO (String customer, Set<OfferDTO> loans) {

}
