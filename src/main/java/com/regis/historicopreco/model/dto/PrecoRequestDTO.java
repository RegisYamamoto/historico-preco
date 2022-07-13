package com.regis.historicopreco.model.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class PrecoRequestDTO {

    @NotNull(message = "campo preco não pode ser null")
    private BigDecimal preco = new BigDecimal(0);

    @NotBlank(message = "campo lojaConsultada não pode ser vazio ou null")
    private String lojaConsultada = "";

}
