package com.pessoa.score.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pessoa {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Include
    private Long id;

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
    private Integer score;
}
