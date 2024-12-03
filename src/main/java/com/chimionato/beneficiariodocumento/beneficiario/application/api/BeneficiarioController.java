package com.chimionato.beneficiariodocumento.beneficiario.application.api;

import com.chimionato.beneficiariodocumento.beneficiario.application.service.BeneficiarioService;
import com.chimionato.beneficiariodocumento.documento.domain.Documento;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@Log4j2
@RequiredArgsConstructor
public class BeneficiarioController implements BeneficiarioAPI {

    private final BeneficiarioService beneficiarioService;

    @Override
    public BeneficiarioResponse postBeneficiario(BeneficiarioRequest beneficiarioRequest) {
        log.info("[inicia]     BeneficiarioController - postBeneficiario");
        BeneficiarioResponse beneficiarioCriado = beneficiarioService.postBeneficiario(beneficiarioRequest);
        log.info("[FINALIZA]   BeneficiarioController - postBeneficiario");
        return beneficiarioCriado;
    }

    @Override
    public List<BeneficiarioListResponse> getTodosBeneficiarios() {
        log.info("[inicia]     BeneficiarioController - getTodosBeneficiarios");
        List<BeneficiarioListResponse> beneficarios = beneficiarioService.getTodosBeneficiarios();
        log.info("[FINALIZA]   BeneficiarioController - getTodosBeneficiarios");
        return beneficarios;
    }

    @Override
    public List<Documento> getDocsUmBeneficiarioPeloId(UUID idBeneficiario) {
        log.info("[inicia]     BeneficiarioController - getDocsUmBeneficiarioPeloId");
        List<Documento> documentos = beneficiarioService.getDocsUmBeneficiarioPeloId(idBeneficiario);
        log.info("[FINALIZA]   BeneficiarioController - getDocsUmBeneficiarioPeloId");
        return documentos;
    }
}