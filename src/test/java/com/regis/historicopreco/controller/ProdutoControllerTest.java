package com.regis.historicopreco.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.regis.historicopreco.Mocks;
import com.regis.historicopreco.dto.ProdutoRequestDTO;
import com.regis.historicopreco.dto.ProdutoResponseDTO;
import com.regis.historicopreco.service.ProdutoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProdutoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ProdutoService produtoService;


    // cenários para o método cadastrarProduto()
    @Test
    public void quandoChamarMetodoCadastrarProduto_deveCadastrarComSucesso() throws Exception {
        ProdutoResponseDTO produtoResponseDtoMock = new ProdutoResponseDTO();

        when(produtoService.listarProdutoPorId("asd123")).thenReturn(produtoResponseDtoMock);

        this.mockMvc.perform(
                post("/produtos")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(Mocks.criarMockDeProdutoRequestDto()))
        ).andExpect(status().isCreated());
        verify(produtoService, times(1)).cadastrarProduto(Mocks.criarMockDeProdutoRequestDto());
    }

    @Test
    public void quandoChamarMetodoCadastrarProdutoComOCampoNomeVazio_deveRetornarStatus400() throws Exception {
        ProdutoRequestDTO produtoRequestDtoMock = Mocks.criarMockDeProdutoRequestDto();
        produtoRequestDtoMock.setNome("");

        this.mockMvc.perform(
                post("/produtos")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(produtoRequestDtoMock))
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void quandoChamarMetodoCadastrarProdutoComIdQueNaoExiste_deveRetornarStatus409() throws Exception {
        when(produtoService.listarProdutoPorId("asd123")).thenReturn(Mocks.criarMockDeProdutoResponseDto());

        this.mockMvc.perform(
                post("/produtos")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(Mocks.criarMockDeProdutoRequestDto()))
        ).andExpect(status().isConflict());
    }


    // cenários para o método listarTodosProdutos()
    @Test
    public void quandoChamarMetodoListarTodosProdutos_deveRetornarComSucesso() throws Exception {
        when(produtoService.listarTodosProdutos(0, 20)).thenReturn(Mocks.criarMockDeProdutoResponsePageDTO());
        this.mockMvc.perform(get("/produtos")).andExpect(status().isOk());
    }


    // cenários para o método listarProdutoPorId()
    @Test
    public void quandoChamarMetodoListarProdutoPorId_deveRetornarOProdutoComSucesso() throws Exception {
        when(produtoService.listarProdutoPorId("asd123")).thenReturn(Mocks.criarMockDeProdutoResponseDto());
        this.mockMvc.perform(get("/produtos/asd123")).andExpect(status().isOk());
    }

    @Test
    public void quandoChamarMetodoListarProdutoPorIdComIdQueNaoExiste_deveRetornarStatus404() throws Exception {
        ProdutoResponseDTO produtoResponseDto = new ProdutoResponseDTO();
        produtoResponseDto.setId("");

        when(produtoService.listarProdutoPorId("asd123")).thenReturn(produtoResponseDto);

        this.mockMvc.perform(get("/produtos/asd123")).andExpect(status().isNotFound());
    }


    // cenários para o método atualizarProduto()
    @Test
    public void quandoChamarOMetodoAtualizarProduto_deveAtualizarComSucesso() throws Exception {
        when(produtoService.listarProdutoPorId(any())).thenReturn(Mocks.criarMockDeProdutoResponseDto());

        this.mockMvc.perform(
                put("/produtos")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(Mocks.criarMockDeProdutoRequestDto()))
        ).andExpect(status().isOk());
        verify(produtoService, times(1)).atualizarProduto(Mocks.criarMockDeProdutoRequestDto(), Mocks.criarMockDeProdutoResponseDto());
    }

    @Test
    public void quandoChamarOMetodoAtualizarProdutoComNomeVazio_deveRetornarErro400() throws Exception {
        ProdutoRequestDTO produtoRequestDto = new ProdutoRequestDTO();
        produtoRequestDto.setNome("");

        this.mockMvc.perform(
                put("/produtos")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(produtoRequestDto))
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void quandoChamarOMetodoAtualizarProdutoComIdQueNaoExiste_deveRetornarErro404() throws Exception {
        when(produtoService.listarProdutoPorId("asd123")).thenReturn(new ProdutoResponseDTO());

        this.mockMvc.perform(
                put("/produtos")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(Mocks.criarMockDeProdutoRequestDto()))
        ).andExpect(status().isNotFound());
    }


    // cenários para o método excluirProduto()
    @Test
    public void quandoChamarOMetodoExcluirProduto_deveExcluirComSucesso() throws Exception {
        when(produtoService.listarProdutoPorId("asd123")).thenReturn(Mocks.criarMockDeProdutoResponseDto());

        this.mockMvc.perform(
                delete("/produtos/asd123")
        ).andExpect(status().isOk());

        verify(produtoService, times(1)).excluirProduto("asd123");
    }

    @Test
    public void quandoChamarOMetodoExcluirProdutoComIdQueNaoExiste_deveRetornarErro404() throws Exception {
        when(produtoService.listarProdutoPorId("asd123")).thenReturn(new ProdutoResponseDTO());

        this.mockMvc.perform(
                delete("/produtos/asd123")
        ).andExpect(status().isNotFound());
    }

}
