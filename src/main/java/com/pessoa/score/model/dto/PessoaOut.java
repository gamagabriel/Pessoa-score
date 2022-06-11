package com.pessoa.score.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PessoaOut {

    private String nome;
    private String telefone;
    private int idade;
    private String scoreDescricao;
}