package com.pessoa.score.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
public class PessoaIn {

    @NotBlank
    private String nome;

    @NotBlank
    private String telefone;

    @NotNull
    private Integer idade;

    @NotBlank
    private String cidade;

    @NotBlank
    private String estado;

    @NotNull
    @Min(0)
    @Max(1000)
    private Integer score;
}
