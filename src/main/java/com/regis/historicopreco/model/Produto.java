package com.regis.historicopreco.model;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.agent.builder.AgentBuilder;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "produto")
public class Produto {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "marca")
    private String marca;

    @Column(name = "data_cadastro")
    private LocalDateTime dataCadastro;

    @Column(name = "data_ult_atualizacao")
    private LocalDateTime dataUltAtualizacao;

    @OneToMany(mappedBy = "produto")
    private List<Preco> precos;

}
