package com.regis.historicopreco.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.regis.historicopreco.Mocks;
import com.regis.historicopreco.model.Preco;
import com.regis.historicopreco.dto.PrecoRequestDTO;
import com.regis.historicopreco.dto.ProdutoResponseDTO;
import com.regis.historicopreco.service.PrecoService;
import com.regis.historicopreco.service.ProdutoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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


    // cenários para o método cadastrarPreco()
    @Test
    public void quandoChamarOMetodoCadastrarPreco_deveCadastrarOPrecoComSucesso() throws Exception {
        when(produtoService.listarProdutoPorId("SM-F926BZKGZTO")).thenReturn(Mocks.criarMockDeProdutoResponseDto());

        this.mockMvc.perform(
                post("/produtos/SM-F926BZKGZTO/precos")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(Mocks.criarMockDePrecoRequestDto()))
        ).andExpect(status().isCreated());
        verify(precoService, times(1)).cadastrarPreco(Mocks.criarMockDePrecoRequestDto(), Mocks.criarMockDeProdutoResponseDto());
    }

    @Test
    public void quandoChamarOMetodoCadastrarPrecoComOCampoPrecoNull_deveRetornarErro400() throws Exception {
        PrecoRequestDTO precoRequestDtoMock = new PrecoRequestDTO();
        precoRequestDtoMock.setPreco(null);

        this.mockMvc.perform(
                post("/produtos/123/precos")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(precoRequestDtoMock))
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void quandoChamarOMetodoCadastrarPrecoComProdutoIdQueNaoExiste_deveRetornarErro404() throws Exception {
        when(produtoService.listarProdutoPorId("123")).thenReturn(new ProdutoResponseDTO());

        this.mockMvc.perform(
                post("/produtos/123/precos")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(Mocks.criarMockDePrecoRequestDto()))
        ).andExpect(status().isNotFound());
    }


    // cenários para o método atualizarPreco()
    @Test
    public void quandoChamarOMetodoAtualizarPreco_deveAtualizarOPrecoComSucesso() throws Exception {
        when(precoService.listarPrecoPorId(3L)).thenReturn(Optional.of(Mocks.criarMockDePreco()));

        this.mockMvc.perform(
                put("/produtos/SM-F926BZKGZT1/precos/3")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(Mocks.criarMockDePrecoRequestDto()))
        ).andExpect(status().isOk());
    }

    @Test
    public void quandoChamarOMetodoAtualizarPrecoComCampoPrecoNull_deveRetornarErro400() throws Exception {
        PrecoRequestDTO precoRequestDtoMock = new PrecoRequestDTO();
        precoRequestDtoMock.setPreco(null);

        this.mockMvc.perform(
                put("/produtos/123/precos/123")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(precoRequestDtoMock))
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void quandoChamarOMetodoAtualizarPrecoComPrecoIdQueNaoExiste_deveRetornarErro404() throws Exception {
        Optional<Preco> precoOpt = Optional.empty();
        when(precoService.listarPrecoPorId(123L)).thenReturn(precoOpt);

        this.mockMvc.perform(
                put("/produtos/123/precos/123")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(Mocks.criarMockDePrecoRequestDto()))
        ).andExpect(status().isNotFound());
    }


    // cenários para o método excluirPreco()
    @Test
    public void quandoChamarOMetodoExcluirPreco_deveExcluirOPrecoComSucesso() throws Exception {
        when(precoService.listarPrecoPorId(3L)).thenReturn(Optional.of(Mocks.criarMockDePreco()));

        this.mockMvc.perform(
                delete("/produtos/SM-F926BZKGZT1/precos/3"))
                .andExpect(status().isOk());
        verify(precoService, times(1)).excluirPreco(3L);
    }

    @Test
    public void quandoChamarOMetodoExcluirPrecoComPrecoIdQueNaoExiste_deveRetornarErro404() throws Exception {
        Optional<Preco> precoOpt = Optional.empty();
        when(precoService.listarPrecoPorId(123L)).thenReturn(precoOpt);

        this.mockMvc.perform(
                delete("/produtos/123/precos/123")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(Mocks.criarMockDePrecoRequestDto()))
        ).andExpect(status().isNotFound());
    }

}
