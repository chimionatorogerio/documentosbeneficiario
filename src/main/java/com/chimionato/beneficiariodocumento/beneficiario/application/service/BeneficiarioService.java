package com.chimionato.beneficiariodocumento.beneficiario.application.service;

import com.chimionato.beneficiariodocumento.beneficiario.application.api.BeneficiarioListResponse;
import com.chimionato.beneficiariodocumento.beneficiario.application.api.BeneficiarioRequest;
import com.chimionato.beneficiariodocumento.beneficiario.application.api.BeneficiarioResponse;
import com.chimionato.beneficiariodocumento.documento.domain.Documento;

import java.util.List;
import java.util.UUID;

public interface BeneficiarioService {
    BeneficiarioResponse postBeneficiario(BeneficiarioRequest beneficiarioRequest);
    List<BeneficiarioListResponse> getTodosBeneficiarios();
    List<Documento> getDocsUmBeneficiarioPeloId(UUID idBeneficiario);
}