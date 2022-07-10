package com.regis.historicopreco.model.dto;

import com.regis.historicopreco.model.Produto;
import com.sun.istack.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PrecoRequestDTO {

    @NotNull
    private BigDecimal preco;

    private LocalDateTime dataConsulta;

    @NotNull
    private String lojaConsultadada;

    private Produto produto;

}
