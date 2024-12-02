package com.chimionato.beneficiariodocumento.beneficiario.application.repository;

import com.chimionato.beneficiariodocumento.beneficiario.domain.Beneficiario;

import java.util.List;

public interface BeneficiarioRepository {
    Beneficiario postBeneficiario(Beneficiario beneficiario);
    List<Beneficiario> getTodosBeneficiarios();
}
