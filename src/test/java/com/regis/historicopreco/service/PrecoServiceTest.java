package com.regis.historicopreco.service;

import com.regis.historicopreco.model.dto.PrecoRequestDTO;
import com.regis.historicopreco.model.dto.ProdutoResponseDTO;
import com.regis.historicopreco.repository.PrecoRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class PrecoServiceTest {

    @Mock
    private PrecoRepository precoRepository;

    @InjectMocks
    private PrecoService precoService;

    @Test
    public void quandoChamoMetodoCadastrarPreco_deveSalvarComSucesso() {
        PrecoRequestDTO precoRequestDtoMock = PrecoRequestDTO.builder()
                .preco(new BigDecimal(10.10))
                .lojaConsultada("Americanas.com")
                .build();

        ProdutoResponseDTO produtoResponseDtoMock = ProdutoResponseDTO.builder()
                .id("aaa")
                .nome("banana")
                .descricao("banana")
                .marca("Panasonic")
                .dataCadastro(LocalDateTime.now())
                .dataUltAtualizacao(LocalDateTime.now())
                .build();

        precoService.cadastrarPreco(precoRequestDtoMock, produtoResponseDtoMock);
        verify(precoRepository, times(1)).save(any());
    }

}