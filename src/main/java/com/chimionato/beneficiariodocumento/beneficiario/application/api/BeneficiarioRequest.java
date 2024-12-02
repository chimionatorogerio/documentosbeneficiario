package com.chimionato.beneficiariodocumento.beneficiario.application.api;

import com.chimionato.beneficiariodocumento.documento.domain.Documento;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.time.LocalDate;
import java.util.List;

@Value
public class BeneficiarioRequest {
    @NotBlank(message = "O campo não deve estar em branco")
    private String nomeCompleto;
    @NotBlank(message = "O campo não deve estar em branco")
    private String telefone;
    @NotNull
    private LocalDate dataNascimento;
    @NotEmpty
    private List<Documento> documentos;
}
