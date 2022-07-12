package com.regis.historicopreco.controller;

import com.regis.historicopreco.model.dto.ProdutoRequestDTO;
import com.regis.historicopreco.model.dto.ProdutoResponseDTO;

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

}
