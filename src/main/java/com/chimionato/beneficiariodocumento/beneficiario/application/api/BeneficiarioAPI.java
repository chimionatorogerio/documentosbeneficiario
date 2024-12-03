package com.chimionato.beneficiariodocumento.beneficiario.application.api;

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

    @GetMapping(value = "/{idBeneficiario}")
    @ResponseStatus(code = HttpStatus.OK)
    BeneficiarioDetalhadoResponse getDocsUmBeneficiarioPeloId(@PathVariable UUID idBeneficiario);
}
