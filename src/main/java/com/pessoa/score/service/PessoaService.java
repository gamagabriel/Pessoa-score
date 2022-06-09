package com.pessoa.score.service;

import com.pessoa.score.model.Pessoa;
import com.pessoa.score.model.dto.PessoaIn;
import com.pessoa.score.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;
    private final ModelMapper modelMapper;

    public void salvaPessoa(PessoaIn pessoaIn){
        Pessoa pessoa = modelMapper.map(pessoaIn, Pessoa.class);
        pessoaRepository.save(pessoa);
    }

}
