package com.chimionato.beneficiariodocumento.beneficiario.application.api;

import com.chimionato.beneficiariodocumento.beneficiario.domain.Beneficiario;
import lombok.Value;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Value
public class BeneficiarioListResponse {
    private UUID idBeneficiario;
    private String nomeCompleto;
    private String telefone;
    private LocalDate dataNascimento;

    public static List<BeneficiarioListResponse> converte(List<Beneficiario> beneficiarios) {
        return beneficiarios.stream()
                .map(BeneficiarioListResponse::new)
                .collect(Collectors.toList());
    }

    private BeneficiarioListResponse(Beneficiario beneficiario) {
        this.idBeneficiario = beneficiario.getIdBeneficiario();
        this.nomeCompleto = beneficiario.getNomeCompleto();
        this.telefone = beneficiario.getTelefone();
        this.dataNascimento = beneficiario.getDataNascimento();
    }
}