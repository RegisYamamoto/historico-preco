package com.regis.historicopreco.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.regis.historicopreco.service.PrecoService;
import com.regis.historicopreco.service.ProdutoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
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
    public void quandoChamarMetodoCadastrarPreco_deveCadastrarOPrecoComSucesso() throws Exception {
        when(produtoService.listarProdutoPorId("SM-F926BZKGZTO")).thenReturn(Mocks.criarMockDeProdutoResponseDTO());
        doNothing().when(precoService).cadastrarPreco(Mocks.criarMockDePrecoRequestDTO(), Mocks.criarMockDeProdutoResponseDTO());

        this.mockMvc.perform(
                post("/produtos/SM-F926BZKGZTO/precos")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(Mocks.criarMockDePrecoRequestDTO()))
        ).andExpect(status().isCreated());
    }

    @Test
    public void quandoChamarMetodoAtualizarPreco_deveAtualizarOPrecoComSucesso() throws Exception {
        when(precoService.listarPrecoPorId(3L)).thenReturn(Optional.of(Mocks.criarMockDePreco()));

        this.mockMvc.perform(
                put("/produtos/SM-F926BZKGZT1/precos/3")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(Mocks.criarMockDePrecoRequestDTO()))
        ).andExpect(status().isOk());
    }

    @Test
    public void quandoChamarMetodoExcluirPreco_deveExcluirOPrecoComSucesso() throws Exception {
        when(precoService.listarPrecoPorId(3L)).thenReturn(Optional.of(Mocks.criarMockDePreco()));
        doNothing().when(precoService).excluirPreco(3L);

        this.mockMvc.perform(
                delete("/produtos/SM-F926BZKGZT1/precos/3"))
                .andExpect(status().isOk());
    }

}
