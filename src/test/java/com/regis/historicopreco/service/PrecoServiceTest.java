package com.regis.historicopreco.service;

import com.regis.historicopreco.Mocks;
import com.regis.historicopreco.repository.PrecoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.Optional;

import static org.mockito.Mockito.*;

@SpringBootTest
public class PrecoServiceTest {

    @MockBean
    private PrecoRepository precoRepository;

    @Autowired
    private PrecoService precoService;


    // cenários para o método cadastrarPreco()
    @Test
    public void quandoChamarOMetodoCadastrarPreco_deveSalvarComSucesso() {
        precoService.cadastrarPreco(Mocks.criarMockDePrecoRequestDto(), Mocks.criarMockDeProdutoResponseDto());
        verify(precoRepository, times(1)).save(any());
    }


    // cenários para o método listarPrecoPorId()
    @Test
    public void quandoChamarOMetodoListarPrecoPorId_deveRetornarOPrecoComSucesso() {
        precoService.listarPrecoPorId(3L);
        verify(precoRepository, times(1)).findById(3L);
    }


    // cenários para o método atualizarPreco()
    @Test
    public void quandoChamarOMetodoAtualizarPreco_deveAtualizarOPrecoComSucesso() {
        precoService.atualizarPreco(Optional.of(Mocks.criarMockDePreco()), Mocks.criarMockDePrecoRequestDto());
        verify(precoRepository, times(1)).save(Mocks.criarMockDePreco());
    }


    // cenários para o método excluirPreco()
    @Test
    public void quandoChamarOMetodoExcluirPreco_deveExcluirOPrecoComSucesso() {
        precoService.excluirPreco(3L);
        verify(precoRepository, times(1)).deleteById(3L);
    }

}
