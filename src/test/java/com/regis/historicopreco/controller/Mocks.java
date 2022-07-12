package com.regis.historicopreco.controller;

import com.regis.historicopreco.model.Preco;
import com.regis.historicopreco.model.dto.PrecoRequestDTO;
import com.regis.historicopreco.model.dto.ProdutoRequestDTO;
import com.regis.historicopreco.model.dto.ProdutoResponseDTO;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Mocks {

    public static ProdutoRequestDTO criarMockDeProdutoRequestDTO() {
        return ProdutoRequestDTO.builder()
                .id("çwlekrjt")
                .nome("banana")
                .descricao("banana")
                .marca("Panasonic")
                .build();
    }

    public static ProdutoResponseDTO criarMockDeProdutoResponseDTO() {
        ProdutoResponseDTO produtoResponseDtoMock = new ProdutoResponseDTO();
        produtoResponseDtoMock.setId("lkjwert");
        produtoResponseDtoMock.setNome("banana novo");
        produtoResponseDtoMock.setDescricao("banana novo");
        produtoResponseDtoMock.setMarca("Panasonic");
        produtoResponseDtoMock.setDataCadastro(LocalDateTime.now());
        produtoResponseDtoMock.setDataUltAtualizacao(LocalDateTime.now());
        return produtoResponseDtoMock;
    }

    public static PrecoRequestDTO criarMockDePrecoRequestDTO() {
        return PrecoRequestDTO.builder()
                .preco(new BigDecimal(10.10))
                .lojaConsultada("Madre Leonia")
                .build();
    }

    public static Preco criarMockDePreco() {
        return Preco.builder()
                .id(3L)
                .preco(new BigDecimal(10.10))
                .dataConsulta(LocalDateTime.now())
                .lojaConsultadada("Americanas.com")
                .build();
    }

}
