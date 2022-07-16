package com.regis.historicopreco.service;

import com.regis.historicopreco.model.Preco;
import com.regis.historicopreco.model.Produto;
import com.regis.historicopreco.dto.PrecoRequestDTO;
import com.regis.historicopreco.dto.ProdutoResponseDTO;
import com.regis.historicopreco.repository.PrecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

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
        preco.setDataConsulta(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")));
        preco.setLojaConsultadada(precoRequestDto.getLojaConsultada());
        preco.setProduto(produto);

        precoRepository.save(preco);
    }

    public Optional<Preco> listarPrecoPorId(Long precoId) {
        return precoRepository.findById(precoId);
    }

    public void atualizarPreco(Optional<Preco> precoOpt, PrecoRequestDTO precoRequestDto) {
        Preco preco = precoOpt.get();
        preco.setPreco(precoRequestDto.getPreco());
        preco.setLojaConsultadada(precoRequestDto.getLojaConsultada());

        precoRepository.save(preco);
    }

    public void excluirPreco(Long precoId) {
        precoRepository.deleteById(precoId);
    }

}
