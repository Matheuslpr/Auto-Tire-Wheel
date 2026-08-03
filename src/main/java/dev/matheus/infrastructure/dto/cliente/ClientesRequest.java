package dev.matheus.infrastructure.dto.cliente;

import dev.matheus.core.enuns.TipoDocumento;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record ClientesRequest(
        @NotBlank(message = "nome é obrigatório")
        String nome,

        @NotNull(message = "tipoDocumento é obrigatório")
        TipoDocumento tipoDocumento,

        @NotBlank(message = "numeroDocumento é obrigatório")
        @Pattern(regexp = "\\d{11}|\\d{14}", message = "numeroDocumento deve conter 11 dígitos (CPF) ou 14 dígitos (CNPJ),")
        String numeroDocumento,

        @NotBlank(message = "email é obrigatório")
        @Email(message = "email inválido")
        String email,

        @NotBlank(message = "telefone é obrigatório")
        @Pattern(regexp = "\\d{10,11}", message = "telefone deve conter DDD + número, apenas dígitos")
        String telefone,

        @NotBlank(message = "logradouro é obrigatório")
        String logradouro,

        @NotBlank(message = "numero é obrigatório")
        String numero,

        @NotBlank(message = "bairro é obrigatório")
        String bairro,

        @NotBlank(message = "cidade é obrigatória")
        String cidade,

        @NotBlank(message = "estado é obrigatório")
        @Pattern(regexp = "[A-Z]{2}", message = "estado deve ser a sigla da UF em maiúsculas")
        String estado,

        @NotBlank(message = "cep é obrigatório")
        @Pattern(regexp = "\\d{8}", message = "cep deve conter 8 dígitos")
        String cep

) {
}
