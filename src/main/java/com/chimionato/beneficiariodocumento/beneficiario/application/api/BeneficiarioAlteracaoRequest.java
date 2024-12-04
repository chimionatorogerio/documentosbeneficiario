package com.chimionato.beneficiariodocumento.beneficiario.application.api;

import com.chimionato.beneficiariodocumento.documento.domain.Documento;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.time.LocalDate;
import java.util.List;

@Value
public class BeneficiarioAlteracaoRequest {
    @NotBlank(message = "O campo não deve estar em branco")
    private String nomeCompleto;
    @NotBlank(message = "O campo não deve estar em branco")
    private String telefone;
    @NotNull
    private LocalDate dataNascimento;
    @NotEmpty
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "beneficiario")
    private List<Documento> documentos;
    private LocalDate dataAlteracao;
}
