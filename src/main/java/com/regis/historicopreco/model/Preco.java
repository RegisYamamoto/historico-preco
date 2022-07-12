package com.regis.historicopreco.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "preco")
public class Preco {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "preco")
    private BigDecimal preco;

    @NotNull
    @Column(name = "data_consulta")
    private LocalDateTime dataConsulta;

    @NotNull
    @Column(name = "loja_consultada")
    private String lojaConsultadada;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produto;

}
