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
        return ProdutoResponseDTO.builder()
                .id("lkjwert")
                .nome("banana novo")
                .descricao("banana novo")
                .marca("Panasonic")
                .dataCadastro(LocalDateTime.now())
                .dataUltAtualizacao(LocalDateTime.now())
                .build();
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
