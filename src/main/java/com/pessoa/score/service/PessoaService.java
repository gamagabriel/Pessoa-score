package com.pessoa.score.service;

import com.pessoa.score.model.Pessoa;
import com.pessoa.score.model.dto.PessoaIn;
import com.pessoa.score.model.dto.PessoaOut;
import com.pessoa.score.model.dto.PessoaOutList;
import com.pessoa.score.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static com.pessoa.score.model.dto.ScoreEnumeration.*;

@RequiredArgsConstructor
@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;
    private final ModelMapper modelMapper;

    public void salvaPessoa(PessoaIn pessoaIn) {
        Pessoa pessoa = modelMapper.map(pessoaIn, Pessoa.class);
        pessoaRepository.save(pessoa);
    }

    public PessoaOut pessoaById(Long id) {
        PessoaOut pessoaOut = null;
        try {
            Pessoa pessoa = pessoaRepository.findById(id).get();
            pessoaOut = modelMapper.map(pessoa, PessoaOut.class);
            var scoreDescricao = mapeiaDescricaoScore(pessoa.getScore());
            pessoaOut.setScoreDescricao(scoreDescricao);
        } catch (NoSuchElementException ex) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
        return pessoaOut;
    }

    public List<PessoaOutList> findAll() {
        List<PessoaOutList> list = new ArrayList<>();
        pessoaRepository.findAll().forEach(pessoa -> {
            PessoaOutList out = new PessoaOutList();
            out.setNome(pessoa.getNome());
            out.setCidade(pessoa.getCidade());
            out.setEstado(pessoa.getEstado());
            out.setScoreDescricao(mapeiaDescricaoScore(pessoa.getScore()));
            list.add(out);
        });

        if (list.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }

        return list;
    }

    private String mapeiaDescricaoScore(Integer score) {
        String descricao = null;

        if (score >= 0 && score <= 200) {
            descricao = INSUFICIENTE.getDescricao();
        }
        if (score >= 201 && score <= 500) {
            descricao = INACEITAVEL.getDescricao();
        }
        if (score >= 501 && score <= 700) {
            descricao = ACEITAVEL.getDescricao();
        }
        if (score >= 701 && score <= 1000) {
            descricao = RECOMENDAVEL.getDescricao();
        }
        return descricao;
    }
}