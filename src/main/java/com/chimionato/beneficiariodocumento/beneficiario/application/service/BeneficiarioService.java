package com.chimionato.beneficiariodocumento.beneficiario.application.service;

import com.chimionato.beneficiariodocumento.beneficiario.application.api.BeneficiarioListResponse;
import com.chimionato.beneficiariodocumento.beneficiario.application.api.BeneficiarioRequest;
import com.chimionato.beneficiariodocumento.beneficiario.application.api.BeneficiarioResponse;

import java.util.List;

public interface BeneficiarioService {
    BeneficiarioResponse postBeneficiario(BeneficiarioRequest beneficiarioRequest);
    List<BeneficiarioListResponse> getTodosBeneficiarios();
}