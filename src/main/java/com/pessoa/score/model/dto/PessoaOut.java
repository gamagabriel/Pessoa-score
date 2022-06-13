package com.pessoa.score.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PessoaOut {

    private String nome;
    private String telefone;
    private Integer idade;
    private String scoreDescricao;
}