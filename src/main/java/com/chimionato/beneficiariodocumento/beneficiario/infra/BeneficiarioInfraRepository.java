package com.chimionato.beneficiariodocumento.beneficiario.infra;

import com.chimionato.beneficiariodocumento.beneficiario.application.repository.BeneficiarioRepository;
import com.chimionato.beneficiariodocumento.beneficiario.domain.Beneficiario;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

@Repository
@Log4j2
@RequiredArgsConstructor
public class BeneficiarioInfraRepository implements BeneficiarioRepository {

    private final BeneficiarioSpringDataJPARepository beneficiarioSpringDataJPARepository;

    @Override
    public Beneficiario postBeneficiario(Beneficiario beneficiario) {
        log.info("[inicia]     BeneficiarioInfraRepository - postBeneficiario");
        beneficiarioSpringDataJPARepository.save(beneficiario);
        log.info("[FINALIZA]   BeneficiarioInfraRepository - postBeneficiario");
        return beneficiario;
    }
}
