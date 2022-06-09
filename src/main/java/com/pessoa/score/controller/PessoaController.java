package com.pessoa.score.controller;

import com.pessoa.score.model.dto.PessoaIn;
import com.pessoa.score.service.PessoaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;

@RequiredArgsConstructor
@RestController
public class PessoaController {

    private final PessoaService pessoaService;

    @PostMapping(value = "/pessoa")
    public ResponseEntity salvarPessoa(@Valid @RequestBody PessoaIn pessoaIn){
        pessoaService.salvaPessoa(pessoaIn);
        return ResponseEntity.status(CREATED).build();
    }


}
