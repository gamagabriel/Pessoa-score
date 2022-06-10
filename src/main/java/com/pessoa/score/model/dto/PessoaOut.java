package com.pessoa.score.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PessoaOut {

    private String nome;
    private String telefone;
    private int idade;
    private String scoreDescricao;
}