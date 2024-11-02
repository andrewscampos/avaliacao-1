package br.com.avaliacao.model;


import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "produtos")
@Data
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUTO_SEQ")
    @SequenceGenerator(name = "PRODUTO_SEQ", sequenceName = "PRODUTO_SEQ", allocationSize = 1)

    private Long id;

    @Column(nullable = false)
    private String nome;

    private String descricao;

    @Column(nullable = false)
    private BigDecimal preco;
    
}
