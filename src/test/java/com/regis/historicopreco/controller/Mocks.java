package com.regis.historicopreco.controller;

import com.regis.historicopreco.model.Preco;
import com.regis.historicopreco.model.dto.PrecoRequestDTO;
import com.regis.historicopreco.model.dto.ProdutoRequestDTO;
import com.regis.historicopreco.model.dto.ProdutoResponseDTO;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Mocks {

    public static ProdutoRequestDTO criarMockDeProdutoRequestDto() {
        ProdutoRequestDTO produtoRequestDto = new ProdutoRequestDTO();
        produtoRequestDto.setId("çwlekrjt");
        produtoRequestDto.setNome("banana");
        produtoRequestDto.setDescricao("banana");
        produtoRequestDto.setMarca("Panasonic");

        return produtoRequestDto;
    }

    public static ProdutoResponseDTO criarMockDeProdutoResponseDto() {
        ProdutoResponseDTO produtoResponseDtoMock = new ProdutoResponseDTO();
        produtoResponseDtoMock.setId("lkjwert");
        produtoResponseDtoMock.setNome("banana novo");
        produtoResponseDtoMock.setDescricao("banana novo");
        produtoResponseDtoMock.setMarca("Panasonic");
        produtoResponseDtoMock.setDataCadastro(LocalDateTime.now());
        produtoResponseDtoMock.setDataUltAtualizacao(LocalDateTime.now());
        return produtoResponseDtoMock;
    }

    public static PrecoRequestDTO criarMockDePrecoRequestDto() {
        PrecoRequestDTO precoRequestDto = new PrecoRequestDTO();
        precoRequestDto.setPreco(new BigDecimal(10.10));
        precoRequestDto.setLojaConsultada("Madre Leonia");

        return precoRequestDto;
    }

    public static Preco criarMockDePreco() {
        Preco preco = new Preco();
        preco.setId(3L);
        preco.setPreco(new BigDecimal(10.10));
        preco.setDataConsulta(LocalDateTime.now());
        preco.setLojaConsultadada("Americanas.com");

        return preco;
    }

}
