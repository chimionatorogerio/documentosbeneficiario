package com.chimionato.beneficiariodocumento.documento.domain;

import com.chimionato.beneficiariodocumento.beneficiario.domain.Beneficiario;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Documento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid",name = "id", nullable = false, unique = true, updatable = false)
    private UUID idDocumento;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "beneficiario_id")
    private Beneficiario beneficiario;
    @NotBlank(message = "O campo não deve estar em branco")
    private String tipoDocumento;
    @NotBlank(message = "O campo não deve estar em branco")
    private String descricao;

    private LocalDate dataInclusao;
    private LocalDate dataAtualizacao;
}
