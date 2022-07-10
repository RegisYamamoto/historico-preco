package com.regis.historicopreco.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class ProdutoRequestDTO {

    private String id;

    @NotBlank(message = "stringValue has to be present")
    private String nome;

    private String descricao;
    private String marca;

}
