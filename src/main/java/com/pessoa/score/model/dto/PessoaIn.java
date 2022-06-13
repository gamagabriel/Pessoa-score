package com.pessoa.score.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@AllArgsConstructor
@Getter
@Setter
public class PessoaIn {

    @NotBlank(message = "O campo nome não pode estar em branco")
    private String nome;

    @NotBlank(message = "O campo telefone não pode estar em branco")
    private String telefone;

    @NotNull(message = "O campo idade não por ser nulo")
    private Integer idade;

    @NotBlank(message = "O campo cidade não pode estar em branco")
    private String cidade;

    @NotBlank(message = "O campo estado não por estar em branco")
    @Size(max = 2, message = "Identifique o estado por sua UF")
    private String estado;

    @NotNull
    @Min(0)
    @Max(value = 1000, message = "O valor de Score não pode ser maior que 1000")
    private Integer score;
}
