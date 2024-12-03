package com.chimionato.beneficiariodocumento.beneficiario.application.repository;

import com.chimionato.beneficiariodocumento.beneficiario.domain.Beneficiario;
import com.chimionato.beneficiariodocumento.documento.domain.Documento;

import java.util.List;
import java.util.UUID;

public interface BeneficiarioRepository {
    Beneficiario postBeneficiario(Beneficiario beneficiario);
    List<Beneficiario> getTodosBeneficiarios();
    Beneficiario getUmBeneficiarioPeloid(UUID idBeneficiario);
}
