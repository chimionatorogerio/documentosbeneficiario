package com.chimionato.beneficiariodocumento.beneficiario.infra;

import com.chimionato.beneficiariodocumento.beneficiario.domain.Beneficiario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BeneficiarioSpringDataJPARepository extends
        JpaRepository<Beneficiario, UUID> {
}
