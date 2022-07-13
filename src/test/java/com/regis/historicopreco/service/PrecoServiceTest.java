package com.regis.historicopreco.service;

import com.regis.historicopreco.controller.Mocks;
import com.regis.historicopreco.model.dto.PrecoRequestDTO;
import com.regis.historicopreco.model.dto.ProdutoResponseDTO;
import com.regis.historicopreco.repository.PrecoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class PrecoServiceTest {

    @MockBean
    private PrecoRepository precoRepository;

    @Autowired
    private PrecoService precoService;

    @Test
    public void quandoChamoMetodoCadastrarPreco_deveSalvarComSucesso() {
        precoService.cadastrarPreco(Mocks.criarMockDePrecoRequestDto(), Mocks.criarMockDeProdutoResponseDto());
        verify(precoRepository, times(1)).save(any());
    }

}
