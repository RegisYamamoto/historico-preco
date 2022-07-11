package com.regis.historicopreco.service;

import com.regis.historicopreco.model.Produto;
import com.regis.historicopreco.model.dto.ProdutoRequestDTO;
import com.regis.historicopreco.model.dto.ProdutoResponseDTO;
import com.regis.historicopreco.repository.PrecoRepository;
import com.regis.historicopreco.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private PrecoRepository precoRepository;

    public void cadastrarProduto(ProdutoRequestDTO produtoRequestDto) {
        Produto produto = Produto.builder()
                .id(produtoRequestDto.getId())
                .nome(produtoRequestDto.getNome())
                .descricao(produtoRequestDto.getDescricao())
                .marca(produtoRequestDto.getMarca())
                .dataCadastro(LocalDateTime.now())
                .build();

        produtoRepository.save(produto);
    }

    public List<ProdutoResponseDTO> listarTodosProdutos() {
        List<Produto> produtos = produtoRepository.findAll();

        List<ProdutoResponseDTO> produtosResponseDto = new ArrayList<>();
        for (Produto produto : produtos) {
            ProdutoResponseDTO produtoResponseDto = ProdutoResponseDTO.builder()
                    .id(produto.getId())
                    .nome(produto.getNome())
                    .descricao(produto.getDescricao())
                    .marca(produto.getMarca())
                    .dataCadastro(produto.getDataCadastro())
                    .dataUltAtualizacao(produto.getDataUltAtualizacao())
                    .precos(produto.getPrecos())
                    .build();
            produtosResponseDto.add(produtoResponseDto);
        }

        return produtosResponseDto;
    }

    public ProdutoResponseDTO listarProdutoPorId(String id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        if (!produto.isPresent()) {
            return null;
        }

        return ProdutoResponseDTO.builder()
                .id(produto.get().getId())
                .nome(produto.get().getNome())
                .descricao(produto.get().getDescricao())
                .marca(produto.get().getMarca())
                .dataCadastro(produto.get().getDataCadastro())
                .dataUltAtualizacao(produto.get().getDataUltAtualizacao())
                .precos(produto.get().getPrecos())
                .build();
    }

    public void atualizarProduto(ProdutoRequestDTO produtoRequestDto, ProdutoResponseDTO produtoResponseDto) {
        Produto produto = Produto.builder()
                .id(produtoRequestDto.getId())
                .nome(produtoRequestDto.getNome())
                .descricao(produtoRequestDto.getDescricao())
                .marca(produtoRequestDto.getMarca())
                .dataCadastro(produtoResponseDto.getDataCadastro())
                .dataUltAtualizacao(LocalDateTime.now())
                .precos(produtoResponseDto.getPrecos())
                .build();

        produtoRepository.save(produto);
    }

    public void excluirProduto(String id) {
        precoRepository.deleteAllByProdutoId(id);
        produtoRepository.deleteById(id);
    }
}
