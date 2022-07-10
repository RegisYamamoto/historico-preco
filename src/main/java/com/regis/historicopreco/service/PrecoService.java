package com.regis.historicopreco.service;

import com.regis.historicopreco.model.Preco;
import com.regis.historicopreco.model.Produto;
import com.regis.historicopreco.model.dto.PrecoRequestDTO;
import com.regis.historicopreco.model.dto.ProdutoResponseDTO;
import com.regis.historicopreco.repository.PrecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class PrecoService {

    @Autowired
    private PrecoRepository precoRepository;

    public void cadastrarPreco(PrecoRequestDTO precoRequestDto, ProdutoResponseDTO produtoResponseDto) {
        Produto produto = new Produto();
        produto.setId(produtoResponseDto.getId());
        produto.setNome(produtoResponseDto.getNome());
        produto.setDescricao(produtoResponseDto.getDescricao());
        produto.setMarca(produtoResponseDto.getMarca());
        produto.setDataCadastro(produtoResponseDto.getDataCadastro());
        produto.setDataUltAtualizacao(produtoResponseDto.getDataUltAtualizacao());

        Preco preco = new Preco();
        preco.setPreco(precoRequestDto.getPreco());
        preco.setDataConsulta(LocalDateTime.now());
        preco.setLojaConsultadada(precoRequestDto.getLojaConsultada());
        preco.setProduto(produto);

        precoRepository.save(preco);
    }

}
