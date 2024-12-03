package com.chimionato.beneficiariodocumento.documento.application.api;

import com.chimionato.beneficiariodocumento.documento.domain.Documento;
import lombok.Value;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Value
public class DocumentoListResponse {
    private UUID idDocumento;
    private String tipoDocumento;
    private String descricao;
    private LocalDate dataInclusao;
    private LocalDate dataAtualizacao;

    public static List<DocumentoListResponse> converte(List<Documento> documentos) {
        return documentos.stream()
                .map(DocumentoListResponse::new)
                .collect(Collectors.toList());
    }

    public DocumentoListResponse(Documento documento) {
        this.idDocumento = documento.getIdDocumento();
        this.tipoDocumento = documento.getTipoDocumento();
        this.descricao = documento.getDescricao();
        this.dataInclusao = documento.getDataInclusao();
        this.dataAtualizacao = documento.getDataAtualizacao();
    }
}
