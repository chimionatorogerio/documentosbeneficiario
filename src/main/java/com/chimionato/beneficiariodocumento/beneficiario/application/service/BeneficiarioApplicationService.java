package com.chimionato.beneficiariodocumento.beneficiario.application.service;

import com.chimionato.beneficiariodocumento.beneficiario.application.api.BeneficiarioListResponse;
import com.chimionato.beneficiariodocumento.beneficiario.application.api.BeneficiarioRequest;
import com.chimionato.beneficiariodocumento.beneficiario.application.api.BeneficiarioResponse;
import com.chimionato.beneficiariodocumento.beneficiario.application.repository.BeneficiarioRepository;
import com.chimionato.beneficiariodocumento.beneficiario.domain.Beneficiario;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class BeneficiarioApplicationService implements BeneficiarioService {

    private final BeneficiarioRepository beneficiarioRepository;

    @Override
    public BeneficiarioResponse postBeneficiario(BeneficiarioRequest beneficiarioRequest) {
        log.info("[inicia]     BeneficiarioApplicationService - postBeneficiario");
        Beneficiario beneficiario = beneficiarioRepository.postBeneficiario(new Beneficiario(beneficiarioRequest));
        log.info("[FINALIZA]   BeneficiarioApplicationService - postBeneficiario");
        return BeneficiarioResponse.builder()
                .idBeneficiario(beneficiario.getIdBeneficiario())
                .build();
    }

    @Override
    public List<BeneficiarioListResponse> getTodosBeneficiarios() {
        log.info("[inicia]     BeneficiarioApplicationService - getTodosBeneficiarios");
        List<Beneficiario> beneficiarios = beneficiarioRepository.getTodosBeneficiarios();
        log.info("[FINALIZA]   BeneficiarioApplicationService - getTodosBeneficiarios");
        return BeneficiarioListResponse.converte(beneficiarios);
    }
}
