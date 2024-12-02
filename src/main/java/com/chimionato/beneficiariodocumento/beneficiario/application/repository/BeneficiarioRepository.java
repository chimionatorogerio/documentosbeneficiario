package com.chimionato.beneficiariodocumento.beneficiario.application.repository;

import com.chimionato.beneficiariodocumento.beneficiario.domain.Beneficiario;

public interface BeneficiarioRepository {
    Beneficiario postBeneficiario(Beneficiario beneficiario);
}
