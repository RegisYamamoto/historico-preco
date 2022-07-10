package com.regis.historicopreco.service;

import com.regis.historicopreco.model.Produto;
import com.regis.historicopreco.model.dto.ProdutoRequestDTO;
import com.regis.historicopreco.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public void salvarProduto(ProdutoRequestDTO produtoRequestDTO) {
        Produto produto = new Produto();
        produto.setId(produtoRequestDTO.getId());
        produto.setNome(produtoRequestDTO.getNome());
        produto.setMarca(produtoRequestDTO.getMarca());
        produto.setDescricao(produtoRequestDTO.getDescricao());
        produtoRepository.save(produto);
    }

}
