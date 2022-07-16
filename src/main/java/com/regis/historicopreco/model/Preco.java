package com.regis.historicopreco.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "preco")
public class Preco implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id = 0L;

    @NotNull
    @Column(name = "preco", nullable = false)
    private BigDecimal preco = new BigDecimal(0.0);

    @NotNull
    @Column(name = "data_consulta", nullable = false)
    private LocalDateTime dataConsulta = LocalDateTime.now();

    @NotNull
    @Column(name = "loja_consultada", nullable = false)
    private String lojaConsultadada = "";

    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produto;

}
