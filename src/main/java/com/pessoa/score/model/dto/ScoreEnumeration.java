package com.pessoa.score.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ScoreEnumeration {
    INSUFICIENTE( "Insuficiente"),
    INACEITAVEL( "Inaceitável"),
    ACEITAVEL( "Aceitável"),
    RECOMENDAVEL("Recomendável");

    private final String descricao;
}