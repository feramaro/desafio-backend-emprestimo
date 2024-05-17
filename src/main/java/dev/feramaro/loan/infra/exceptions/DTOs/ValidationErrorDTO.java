package dev.feramaro.loan.infra.exceptions.DTOs;

import java.util.List;

public record ValidationErrorDTO(String message, Long timestamp, List<FieldErrorDTO> errors) {
}
