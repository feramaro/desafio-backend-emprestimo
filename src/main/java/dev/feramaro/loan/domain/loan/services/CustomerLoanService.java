package dev.feramaro.loan.domain.loan.services;

import dev.feramaro.loan.domain.loan.DTOs.LoanDTO;
import dev.feramaro.loan.domain.loan.DTOs.LoanRequestDTO;
import dev.feramaro.loan.domain.loan.DTOs.OfferDTO;
import dev.feramaro.loan.domain.loan.enums.LoanType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;


@Service
public class CustomerLoanService {

    public ResponseEntity<LoanDTO> verifyLoan(LoanRequestDTO loanRequest) {

        Set<OfferDTO> offers = new LinkedHashSet<>();
        if (loanRequest.income() <= 3000) {
            offers.add(new OfferDTO(LoanType.PERSONAL, LoanType.PERSONAL.getInterestRate()));
            offers.add(new OfferDTO(LoanType.GUARANTEED, LoanType.GUARANTEED.getInterestRate()));
        }
        if (loanRequest.income() >= 3000 && loanRequest.income() <= 5000 && loanRequest.age() < 30 && "SP".equals(loanRequest.location())) {
            offers.add(new OfferDTO(LoanType.PERSONAL, LoanType.PERSONAL.getInterestRate()));
            offers.add(new OfferDTO(LoanType.GUARANTEED, LoanType.GUARANTEED.getInterestRate()));
        }
        if (loanRequest.income() >= 5000) {
            offers.add(new OfferDTO(LoanType.CONSIGNMENT, LoanType.CONSIGNMENT.getInterestRate()));
        }


        LoanDTO loanDTO = new LoanDTO(loanRequest.name(), offers);

        return ResponseEntity.ok(loanDTO);


    }
}
