package com.pessoa.score.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PessoaOutList {

    private String nome;
    private String cidade;
    private String estado;
    private String scoreDescricao;
}
