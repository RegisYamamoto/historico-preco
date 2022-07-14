package com.regis.historicopreco;

import com.regis.historicopreco.model.Preco;
import com.regis.historicopreco.model.Produto;
import com.regis.historicopreco.model.dto.PrecoRequestDTO;
import com.regis.historicopreco.model.dto.ProdutoRequestDTO;
import com.regis.historicopreco.model.dto.ProdutoResponseDTO;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Mocks {

    public static ProdutoRequestDTO criarMockDeProdutoRequestDto() {
        ProdutoRequestDTO produtoRequestDtoMock = new ProdutoRequestDTO();
        produtoRequestDtoMock.setId("asd123");
        produtoRequestDtoMock.setNome("Banana");
        produtoRequestDtoMock.setDescricao("Banana");
        produtoRequestDtoMock.setMarca("Panasonic");

        return produtoRequestDtoMock;
    }

    public static ProdutoResponseDTO criarMockDeProdutoResponseDto() {
        ProdutoResponseDTO produtoResponseDtoMock = new ProdutoResponseDTO();
        produtoResponseDtoMock.setId("asd123");
        produtoResponseDtoMock.setNome("Banana");
        produtoResponseDtoMock.setDescricao("Banana");
        produtoResponseDtoMock.setMarca("Panasonic");
        produtoResponseDtoMock.setDataCadastro(LocalDateTime.of(2022, 7, 13, 23, 1, 1));
        produtoResponseDtoMock.setDataUltAtualizacao(LocalDateTime.of(2022, 7, 13, 23, 1, 1));

        return produtoResponseDtoMock;
    }

    public static PrecoRequestDTO criarMockDePrecoRequestDto() {
        PrecoRequestDTO precoRequestDtoMock = new PrecoRequestDTO();
        precoRequestDtoMock.setPreco(new BigDecimal(10.10));
        precoRequestDtoMock.setLojaConsultada("Americanas.com");

        return precoRequestDtoMock;
    }

    public static Preco criarMockDePreco() {
        Preco precoMock = new Preco();
        precoMock.setId(3L);
        precoMock.setPreco(new BigDecimal(10.10));
        precoMock.setDataConsulta(LocalDateTime.of(2022, 7, 13, 23, 1, 1));
        precoMock.setLojaConsultadada("Americanas.com");

        return precoMock;
    }

    public static Produto criarMockDeProduto() {
        Produto produtoMock = new Produto();
        produtoMock.setId("asd123");
        produtoMock.setNome("Banana");
        produtoMock.setDescricao("Banana");
        produtoMock.setMarca("Panasonic");
        produtoMock.setDataCadastro(LocalDateTime.of(2022, 7, 13, 23, 1, 1));
        produtoMock.setDataUltAtualizacao(LocalDateTime.of(2022, 7, 13, 23, 1, 1));

        return produtoMock;
    }

}
