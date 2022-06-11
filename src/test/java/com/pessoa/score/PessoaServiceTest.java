package com.pessoa.score;

import com.pessoa.score.model.Pessoa;
import com.pessoa.score.model.dto.PessoaIn;
import com.pessoa.score.repository.PessoaRepository;
import com.pessoa.score.service.PessoaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PessoaServiceTest {

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Test
    public void deveriaSalvarUmaNovaPessoa() {

        //Given
        PessoaIn pessoaIn = getPessoaInBuild();
        //When
        Pessoa salvaPessoa = pessoaService.salvaPessoa(pessoaIn);
        Long id = salvaPessoa.getId();

        //Then
        Pessoa esperado = pessoaRepository.findById(id).orElse(null);
        assertNotNull(esperado);
        assertEquals(esperado, salvaPessoa);
    }

    @Test
    public void naoDeveriaSalvarUmaPessoaComDadosNulos() {

        //Given
        PessoaIn pessoaIn = PessoaIn.builder()
                .nome(null)
                .telefone("99 99999-9999")
                .idade(99)
                .cidade(null)
                .estado("")
                .score(1000)
                .build();

        //When
        try {
            pessoaService.salvaPessoa(pessoaIn);
            fail();
        } catch (RuntimeException exception) {
        }

    }

    @Test
    public void deveriaRetornarPessoaById(){
        //Given
        Pessoa pessoa = getPessoaBuild();
        //WHEN
        var id = pessoaRepository.save(pessoa).getId();

        //THEN
        var esperado = pessoaService.pessoaById(id);
        assertNotNull(esperado);
    }

    @Test
    public void deveriaRetornarTodasAsPessoas(){
        //GIVEN
        int numPessoas = 3;
        for (int i = 0; i < numPessoas; i++) {
            pessoaRepository.save(getPessoaBuild());
        }

        //WHEN
        var listaPessoas = pessoaService.findAll();

        //THEN
        assertNotNull(listaPessoas);
        assertEquals(numPessoas, listaPessoas.size());
    }

    private Pessoa getPessoaBuild() {
        return Pessoa.builder()
                .nome("Fulano de Tal")
                .telefone("99 99999-9999")
                .idade(99)
                .cidade("Cidade de Fulano")
                .estado("XX")
                .score(1000)
                .build();
    }

    private PessoaIn getPessoaInBuild() {
        return PessoaIn.builder()
                .nome("Fulano de Tal")
                .telefone("99 99999-9999")
                .idade(99)
                .cidade("Cidade de Fulano")
                .estado("XX")
                .score(1000)
                .build();
    }
}
