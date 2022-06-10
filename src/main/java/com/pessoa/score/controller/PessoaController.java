package com.pessoa.score.controller;

import com.pessoa.score.model.dto.PessoaIn;
import com.pessoa.score.model.dto.PessoaOut;
import com.pessoa.score.model.dto.PessoaOutList;
import com.pessoa.score.service.PessoaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/pessoa")
public class PessoaController {

    private final PessoaService pessoaService;

    @PostMapping
    public ResponseEntity salvarPessoa(@Valid @RequestBody PessoaIn pessoaIn){
        pessoaService.salvaPessoa(pessoaIn);
        return ResponseEntity.status(CREATED).build();
    }

    @GetMapping(value = "/{id}")
    public PessoaOut pessoaById(@PathVariable Long id){
        return pessoaService.pessoaById(id);
    }

    @GetMapping
    public List<PessoaOutList> pessoaByAll(){
        return pessoaService.findAll();
    }
}
