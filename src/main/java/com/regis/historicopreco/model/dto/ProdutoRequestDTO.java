package com.regis.historicopreco.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoRequestDTO {

    private String id;

    @NotBlank(message = "campo nome não pode ser vazio ou null")
    private String nome;

    private String descricao;
    private String marca;

}
