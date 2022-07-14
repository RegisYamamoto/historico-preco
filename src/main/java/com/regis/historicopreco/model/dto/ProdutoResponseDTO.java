package com.regis.historicopreco.model.dto;

import com.regis.historicopreco.model.Preco;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class ProdutoResponseDTO {

    private String id = "";
    private String nome = "";
    private String descricao = "";
    private String marca = "";
    private LocalDateTime dataCadastro = LocalDateTime.now();
    private LocalDateTime dataUltAtualizacao = LocalDateTime.now();
    private List<PrecoResponseDTO> precos = new ArrayList<>();

}
