package com.regis.historicopreco.model.dto;

import com.regis.historicopreco.model.Preco;
import lombok.Data;
import java.util.List;

@Data
public class ProdutoRequestDTO {

    private String id;
    private String nome;
    private String descricao;
    private String marca;

}
