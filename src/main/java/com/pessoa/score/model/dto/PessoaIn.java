package com.pessoa.score.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
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
    @Min(0)
    @Max(1000)
    private int score;
}
