package com.chimionato.beneficiariodocumento.beneficiario.application.service;

import com.chimionato.beneficiariodocumento.beneficiario.application.api.BeneficiarioAlteracaoRequest;
import com.chimionato.beneficiariodocumento.beneficiario.application.api.BeneficiarioListResponse;
import com.chimionato.beneficiariodocumento.beneficiario.application.api.BeneficiarioRequest;
import com.chimionato.beneficiariodocumento.beneficiario.application.api.BeneficiarioResponse;
import com.chimionato.beneficiariodocumento.documento.application.api.DocumentoListResponse;
import com.chimionato.beneficiariodocumento.documento.domain.Documento;
import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;

public interface BeneficiarioService {
    BeneficiarioResponse postBeneficiario(BeneficiarioRequest beneficiarioRequest);
    List<BeneficiarioListResponse> getTodosBeneficiarios();
    List<DocumentoListResponse> getDocsUmBeneficiarioPeloId(UUID idBeneficiario);
    void patchAlteraBeneficiario(UUID idBeneficiario, @Valid BeneficiarioAlteracaoRequest beneficiarioAlteracaoRequest);
}