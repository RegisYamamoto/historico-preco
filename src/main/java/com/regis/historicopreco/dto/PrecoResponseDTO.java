package com.regis.historicopreco.dto;

import com.regis.historicopreco.model.Produto;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PrecoResponseDTO {

    private long id = 0L;
    private BigDecimal preco = new BigDecimal(0.0);
    private LocalDateTime dataConsulta = LocalDateTime.now();
    private String lojaConsultadada = "";

}
