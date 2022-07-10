package com.regis.historicopreco.model.dto;

import com.regis.historicopreco.model.Preco;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class ProdutoResponseDTO {

    private String id;
    private String nome;
    private String descricao;
    private String marca;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataUltAtualizacao;
    private List<Preco> precos;

}
