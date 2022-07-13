package com.regis.historicopreco.model.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ProdutoRequestDTO {

    private String id = "";

    @NotBlank(message = "campo nome não pode ser vazio ou null")
    private String nome = "";

    private String descricao = "";
    private String marca = "";

}
