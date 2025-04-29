package br.com.fiap.cash_up_api.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record Credentials(
    @Email
    @NotBlank
    String email,

    @NotBlank
    String password
) {}
