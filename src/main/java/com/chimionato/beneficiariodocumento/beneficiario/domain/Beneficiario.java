package com.chimionato.beneficiariodocumento.beneficiario.domain;

import com.chimionato.beneficiariodocumento.beneficiario.application.api.BeneficiarioAlteracaoRequest;
import com.chimionato.beneficiariodocumento.beneficiario.application.api.BeneficiarioRequest;
import com.chimionato.beneficiariodocumento.documento.domain.Documento;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Beneficiario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid",name = "id", nullable = false, unique = true, updatable = false)
    private UUID idBeneficiario;
    @NotBlank(message = "O campo não deve estar em branco")
    private String nomeCompleto;
    @NotBlank(message = "O campo não deve estar em branco")
    private String telefone;
    @NotNull
    private LocalDate dataNascimento;
    @NotEmpty
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "beneficiario")
    private List<Documento> documentos;

    private LocalDate dataInclusao;
    private LocalDate ultimaAtualizacao;

    public Beneficiario(BeneficiarioRequest beneficiarioRequest) {
        this.nomeCompleto = beneficiarioRequest.getNomeCompleto();
        this.telefone = beneficiarioRequest.getTelefone();
        this.dataNascimento = beneficiarioRequest.getDataNascimento();
        this.dataInclusao = LocalDate.now();
        if(beneficiarioRequest.getDocumentos()!=null) {
            this.documentos = beneficiarioRequest.getDocumentos();
            for (Documento documento:this.documentos) {
                documento.setBeneficiario(this);
                documento.setDataInclusao(LocalDate.now());
            }
        }
    }

    public void patchAlteraBeneficiario(
            @Valid BeneficiarioAlteracaoRequest beneficiarioAlteracaoRequest) {
        atualizarInformacoesBasicas(beneficiarioAlteracaoRequest);

        if (Objects.nonNull(beneficiarioAlteracaoRequest.getDocumentos())) {
            atualizarDocumentos(beneficiarioAlteracaoRequest.getDocumentos());
        }

    }

    private void atualizarInformacoesBasicas(
            @Valid BeneficiarioAlteracaoRequest beneficiarioAlteracaoRequest) {
        this.nomeCompleto = beneficiarioAlteracaoRequest.getNomeCompleto();
        this.telefone = beneficiarioAlteracaoRequest.getTelefone();
        this.dataNascimento = beneficiarioAlteracaoRequest.getDataNascimento();
        this.ultimaAtualizacao = LocalDate.now();
    }

    private void atualizarDocumentos(@NotEmpty List<Documento> novosDocumentos) {
        novosDocumentos.forEach(this::processarDocumento);
    }

    private void processarDocumento(Documento documentoNovo) {
        Documento documentoExistente = buscarDocumentoExistente(documentoNovo.getIdDocumento());

        if (Objects.nonNull(documentoExistente)) {
            atualizarDocumento(documentoExistente, documentoNovo);
        } else {
            adicionarNovoDocumento(documentoNovo);
        }
    }

    private Documento buscarDocumentoExistente(UUID documentoId) {
        return this.documentos.stream()
                .filter(doc -> Objects.equals(doc.getIdDocumento(), documentoId))
                .findFirst()
                .orElse(null);
    }

    private void atualizarDocumento(Documento documentoExistente, Documento documentoNovo) {
        documentoExistente.setTipoDocumento(documentoNovo.getTipoDocumento());
        documentoExistente.setDescricao(documentoNovo.getDescricao());
        documentoExistente.setDataAtualizacao(LocalDate.now());
        }

    private void adicionarNovoDocumento(Documento documentoNovo) {
        documentoNovo.setBeneficiario(this);
        documentoNovo.setDataInclusao(LocalDate.now());
        this.documentos.add(documentoNovo);
    }
}