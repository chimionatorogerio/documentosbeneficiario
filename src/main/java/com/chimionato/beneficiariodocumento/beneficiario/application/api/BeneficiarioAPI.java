package com.chimionato.beneficiariodocumento.beneficiario.application.api;

import com.chimionato.beneficiariodocumento.documento.application.api.DocumentoListResponse;
import com.chimionato.beneficiariodocumento.documento.domain.Documento;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/beneficiario")
public interface BeneficiarioAPI {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    BeneficiarioResponse postBeneficiario(@Valid @RequestBody BeneficiarioRequest beneficiarioRequest);

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<BeneficiarioListResponse> getTodosBeneficiarios();

    @GetMapping(value = "/{idBeneficiario}/documentos")
    @ResponseStatus(code = HttpStatus.OK)
    List<DocumentoListResponse> getDocsUmBeneficiarioPeloId(@PathVariable UUID idBeneficiario);

    @PatchMapping(value = "/{idBeneficiario}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void patchAlteraBeneficiario(@PathVariable UUID idBeneficiario,
                                @Valid @RequestBody BeneficiarioAlteracaoRequest beneficiarioAlteracaoRequest);

//inicia implantação delete
}
