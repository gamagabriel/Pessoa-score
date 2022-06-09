package com.pessoa.score.model.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class PessoaIn {

    @NotBlank
    private String nome;

    @NotBlank
    private String telefone;

    @NotNull
    private int idade;

    @NotBlank
    private String cidade;

    @NotBlank
    private String estado;

    @NotNull
    private int score;
}
