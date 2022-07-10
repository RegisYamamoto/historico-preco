package com.regis.historicopreco.service;

import com.regis.historicopreco.model.Produto;
import com.regis.historicopreco.model.dto.ProdutoRequestDTO;
import com.regis.historicopreco.model.dto.ProdutoResponseDTO;
import com.regis.historicopreco.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public void salvarProduto(ProdutoRequestDTO produtoRequestDTO) {
        Produto produto = new Produto();
        produto.setId(produtoRequestDTO.getId());
        produto.setNome(produtoRequestDTO.getNome());
        produto.setDescricao(produtoRequestDTO.getDescricao());
        produto.setMarca(produtoRequestDTO.getMarca());
        produto.setDataCadastro(LocalDateTime.now());
        produtoRepository.save(produto);
    }

    public List<ProdutoResponseDTO> listarTodosProdutos() {
        List<Produto> produtos = produtoRepository.findAll();

        List<ProdutoResponseDTO> produtosResponseDTO = new ArrayList<>();
        for (Produto produto : produtos) {
            ProdutoResponseDTO produtoResponseDTO = ProdutoResponseDTO.builder()
                    .id(produto.getId())
                    .nome(produto.getNome())
                    .descricao(produto.getDescricao())
                    .marca(produto.getMarca())
                    .dataCadastro(produto.getDataCadastro())
                    .dataUltAtualizacao(produto.getDataUltAtualizacao())
                    .precos(produto.getPrecos())
                    .build();
            produtosResponseDTO.add(produtoResponseDTO);
        }

        return produtosResponseDTO;
    }

    public ProdutoResponseDTO listarProdutoPorId(String id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        if (!produto.isPresent()) {
            return null;
        }
        ProdutoResponseDTO produtoResponseDTO = ProdutoResponseDTO.builder()
                .id(produto.get().getId())
                .nome(produto.get().getNome())
                .descricao(produto.get().getDescricao())
                .marca(produto.get().getMarca())
                .dataCadastro(produto.get().getDataCadastro())
                .dataUltAtualizacao(produto.get().getDataUltAtualizacao())
                .precos(produto.get().getPrecos())
                .build();
        return produtoResponseDTO;
    }
}
