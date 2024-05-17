package dev.feramaro.loan.domain.loan.DTOs;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;


public record LoanRequestDTO(
        @NotNull @Min(18) Integer age,
        @CPF String cpf,
        @NotNull @NotEmpty String name,
        @NotNull @Min(1) Double income,
        @NotNull @Size(min = 2, max = 2) String location
) {
}
