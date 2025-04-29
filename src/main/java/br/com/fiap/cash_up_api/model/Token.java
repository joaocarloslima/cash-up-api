package br.com.fiap.cash_up_api.model;

public record Token(
    String token,
    Long expiration,
    String type,
    String role
) {

}
