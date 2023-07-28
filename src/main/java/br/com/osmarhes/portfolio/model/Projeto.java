package br.com.osmarhes.portfolio.model;

import br.com.osmarhes.portfolio.model.enuns.Risco;
import br.com.osmarhes.portfolio.model.enuns.StatusProjeto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "projeto")
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String nome;

    @Column
    private LocalDate dataInicio;

    @Column
    private LocalDate dataPrevisaoFim;

    @Column
    private LocalDate dataFim;

    @Column(length = 5000)
    private String descricao;

    @Column(length = 45)
    @Enumerated(EnumType.STRING)
    private StatusProjeto status;

    @Column
    private Float orcamento;

    @Column(length = 45)
    @Enumerated(EnumType.STRING)
    private Risco risco;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idgerente", nullable = false)
    private Pessoa gerente;

}
