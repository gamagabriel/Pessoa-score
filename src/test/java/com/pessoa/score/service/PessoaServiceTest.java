package com.pessoa.score.service;

import com.pessoa.score.model.Pessoa;
import com.pessoa.score.model.dto.PessoaIn;
import com.pessoa.score.model.dto.PessoaOut;
import com.pessoa.score.repository.PessoaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.Optional;

import static com.pessoa.score.model.dto.ScoreEnumeration.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PessoaServiceTest {

    @InjectMocks
    private PessoaService pessoaService;

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private PessoaRepository pessoaRepository;

    private PessoaIn pessoaIn;

    private Pessoa pessoa;

    private PessoaOut pessoaOut;

    @BeforeEach
    void setup() {
        pessoaIn = pessoaIn();
        pessoa = pessoa();
        pessoaOut = pessoaOut();
    }

    @DisplayName("Deve salvar uma pessoa com sucesso")
    @Test
    void deveSalvarPessoaComSucesso() {
        when(modelMapper.map(pessoaIn, Pessoa.class)).thenReturn(pessoa);

        assertDoesNotThrow(() -> pessoaService.salvaPessoa(pessoaIn));
    }

    @DisplayName("Deve buscar uma pessoa por Id com sucesso")
    @Test
    void deveBuscarPessoaPorIdComSucesso() {
        when(pessoaRepository.findById(1L)).thenReturn(Optional.of(pessoa));
        when(modelMapper.map(pessoa, PessoaOut.class)).thenReturn(pessoaOut);

        var response = assertDoesNotThrow(() -> pessoaService.pessoaById(1L));
        assertNotNull(response);
    }

    @DisplayName("Deve lançar um 204 NO_CONTENT quando Id não for encontrado")
    @Test
    void deveLancar204NoContentQuandoIdPessoaNaoEncontrado() {
        var response = assertThrows(ResponseStatusException.class, () -> pessoaService.pessoaById(1L));
        assertEquals(HttpStatus.NO_CONTENT, response.getStatus());
    }

    @DisplayName("Deve buscar todas as pessoas com sucesso")
    @Test
    void deveBuscarTodasPessoasComSucesso() {
        when(pessoaRepository.findAll()).thenReturn(Arrays.asList(pessoa, pessoa));
        var response = assertDoesNotThrow(() -> pessoaService.findAll());
        assertNotNull(response);
        assertFalse(response.isEmpty());
    }

    @DisplayName("Deve lançar um 204 NO_CONTENT quando retornar lista vazia")
    @Test
    void deveLancar204NoContentQuandoRetornarListaVazia() {
        var response = assertThrows(ResponseStatusException.class, () -> pessoaService.findAll());
        assertEquals(HttpStatus.NO_CONTENT, response.getStatus());
    }

    @DisplayName("Deve mapear a descrição Score RECOMENDÁVEL")
    @Test
    void deveMapearDescricaoScoreRecomendavel(){
       var response =  pessoaService.mapeiaDescricaoScore(1000);
       assertEquals(RECOMENDAVEL.getDescricao(), response);
       assertNotNull(response);
    }

    @DisplayName("Deve mapear a descrição Score ACEITÁVEL")
    @Test
    void deveMapearDescricaoScoreAceitavel(){
        var response =  pessoaService.mapeiaDescricaoScore(700);
        assertEquals(ACEITAVEL.getDescricao(), response);
        assertNotNull(response);
    }

    @DisplayName("Deve mapear a descrição Score INACEITÁVEL")
    @Test
    void deveMapearDescricaoScoreInaceitavel(){
        var response =  pessoaService.mapeiaDescricaoScore(500);
        assertEquals(INACEITAVEL.getDescricao(), response);
        assertNotNull(response);
    }

    @DisplayName("Deve mapear a descrição Score INSUFICIENTE")
    @Test
    void deveMapearDescricaoScoreInsuficiente(){
        var response =  pessoaService.mapeiaDescricaoScore(200);
        assertEquals(INSUFICIENTE.getDescricao(), response);
        assertNotNull(response);
    }

    PessoaIn pessoaIn() {
        return new PessoaIn("Fulano de Tal", "99 99999-9999", 99, "Cidade de Fulano", "XX", 1000);
    }

    Pessoa pessoa() {
        return new Pessoa(null, "Fulano de Tal", "99 99999-9999", 99, "Cidade de Fulano", "XX", 1000);
    }

    PessoaOut pessoaOut() {
        return new PessoaOut("Fulano de Tal", "99 99999-9999", 99, null);
    }

}
