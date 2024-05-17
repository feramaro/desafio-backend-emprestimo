package dev.feramaro.loan.domain.loan.controllers;

import dev.feramaro.loan.domain.loan.DTOs.LoanDTO;
import dev.feramaro.loan.domain.loan.DTOs.LoanRequestDTO;
import dev.feramaro.loan.domain.loan.services.CustomerLoanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer-loans")
public class CustomerLoanController {

    @Autowired
    private CustomerLoanService loanService;

    @PostMapping
    public ResponseEntity<LoanDTO> getLoans(@RequestBody @Valid LoanRequestDTO loanRequest) {
        return loanService.verifyLoan(loanRequest);
    }

}
