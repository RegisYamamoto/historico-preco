package com.regis.historicopreco.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "produto")
public class Produto {

    @Id
    @Column(name = "id")
    private String id = "";

    @Column(name = "nome")
    private String nome = "";

    @Column(name = "descricao")
    private String descricao = "";

    @Column(name = "marca")
    private String marca = "";

    @Column(name = "data_cadastro")
    private LocalDateTime dataCadastro = LocalDateTime.now();

    @Column(name = "data_ult_atualizacao")
    private LocalDateTime dataUltAtualizacao = LocalDateTime.now();

    @OneToMany(mappedBy = "produto")
    private List<Preco> precos = new ArrayList<>();

}
