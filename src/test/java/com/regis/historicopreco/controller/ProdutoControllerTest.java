package com.regis.historicopreco.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.regis.historicopreco.model.dto.ProdutoRequestDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProdutoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void quandoChamarMetodoListarTodosProdutos_deveRetornarComSucesso2() throws Exception {
        this.mockMvc.perform(get("/produtos")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("marca")));
    }

    @Test
    public void quandoChamarMetodoCadastrarProduto_deveCadastrarComSucesso() throws Exception {
        ProdutoRequestDTO produtoRequestDtoMock = ProdutoRequestDTO.builder()
                .id(String.valueOf(Math.random()))
                .nome("banana")
                .descricao("banana")
                .marca("Panasonic")
                .build();

        this.mockMvc.perform(
                post("/produtos")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(produtoRequestDtoMock))
        ).andExpect(status().isCreated());
    }

}
