package com.regis.historicopreco.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.regis.historicopreco.model.Produto;
import com.regis.historicopreco.model.dto.PrecoRequestDTO;
import com.regis.historicopreco.model.dto.ProdutoResponseDTO;
import com.regis.historicopreco.service.PrecoService;
import com.regis.historicopreco.service.ProdutoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;

@SpringBootTest
@AutoConfigureMockMvc
public class PrecoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private PrecoService precoService;

    @MockBean
    private ProdutoService produtoService;

    @Test
    public void quandoChamarMetodoCadastrarPreco_deveCadastrarComSucesso() throws Exception {
        PrecoRequestDTO precoRequestDtoMock = PrecoRequestDTO.builder()
                .preco(new BigDecimal(10.10))
                .lojaConsultada("Madre Leonia")
                .build();

        ProdutoResponseDTO produtoResponseDtoMock = ProdutoResponseDTO.builder()
                .id("qwe5lkhj")
                .nome("banana")
                .descricao("banana")
                .marca("Panasonic")
                .dataCadastro(LocalDateTime.now())
                .dataUltAtualizacao(LocalDateTime.now())
                .build();

        when(produtoService.listarProdutoPorId("SM-F926BZKGZTO")).thenReturn(Mocks.criarMockDeProdutoResponseDTO());
        doNothing().when(precoService).cadastrarPreco(precoRequestDtoMock, produtoResponseDtoMock);

        this.mockMvc.perform(
                post("/produtos/SM-F926BZKGZTO/precos")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(precoRequestDtoMock))
        ).andExpect(status().isCreated());
    }

}
