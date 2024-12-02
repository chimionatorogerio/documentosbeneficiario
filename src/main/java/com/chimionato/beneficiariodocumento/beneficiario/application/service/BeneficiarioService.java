package com.chimionato.beneficiariodocumento.beneficiario.application.service;

import com.chimionato.beneficiariodocumento.beneficiario.application.api.BeneficiarioRequest;
import com.chimionato.beneficiariodocumento.beneficiario.application.api.BeneficiarioResponse;

public interface BeneficiarioService {
    BeneficiarioResponse postBeneficiario(BeneficiarioRequest beneficiarioRequest);
}
