package com.regis.historicopreco.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.regis.historicopreco.model.dto.ProdutoResponseDTO;
import com.regis.historicopreco.service.ProdutoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.any;

@SpringBootTest
@AutoConfigureMockMvc
public class ProdutoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ProdutoService produtoService;

    @Test
    public void quandoChamarMetodoListarTodosProdutos_deveRetornarComSucesso() throws Exception {
        List<ProdutoResponseDTO> produtosResponseDtoMock = new ArrayList<>();
        produtosResponseDtoMock.add(Mocks.criarMockDeProdutoResponseDTO());

        when(produtoService.listarTodosProdutos()).thenReturn(produtosResponseDtoMock);

        this.mockMvc.perform(get("/produtos")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("marca")));
    }

    @Test
    public void quandoChamarMetodoCadastrarProduto_deveCadastrarComSucesso() throws Exception {
        when(produtoService.listarProdutoPorId("kjh345")).thenReturn(null);
        doNothing().when(produtoService).cadastrarProduto(Mocks.criarMockDeProdutoRequestDTO());

        this.mockMvc.perform(
                post("/produtos")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(Mocks.criarMockDeProdutoRequestDTO()))
        ).andExpect(status().isCreated());
    }

    @Test
    public void quandoChamarOMetodoAtualizarProduto_deveAtualizarComSucesso() throws Exception {
        when(produtoService.listarProdutoPorId(any())).thenReturn(Mocks.criarMockDeProdutoResponseDTO());
        doNothing().when(produtoService).atualizarProduto(Mocks.criarMockDeProdutoRequestDTO(), Mocks.criarMockDeProdutoResponseDTO());

        this.mockMvc.perform(
                put("/produtos")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(Mocks.criarMockDeProdutoRequestDTO()))
        ).andExpect(status().isOk());
    }

    @Test
    public void quandoChamarOMetodoExcluirProduto_deveExcluirComSucesso() throws Exception {
        when(produtoService.listarProdutoPorId("lçkj345")).thenReturn(Mocks.criarMockDeProdutoResponseDTO());
        doNothing().when(produtoService).excluirProduto("lçkj345");

        this.mockMvc.perform(
                delete("/produtos/lçkj345")
        ).andExpect(status().isOk());

        produtoService.excluirProduto("lkjh2345");
    }

    @Test
    public void quandoChamarMetodoListarProdutoPorId_deveRetornarOProdutoComSucesso() throws Exception {
        when(produtoService.listarProdutoPorId("aaa444")).thenReturn(Mocks.criarMockDeProdutoResponseDTO());

        this.mockMvc.perform(get("/produtos/aaa444")).andExpect(status().isOk());
    }

}
