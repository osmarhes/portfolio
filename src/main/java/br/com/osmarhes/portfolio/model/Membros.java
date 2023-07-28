package br.com.osmarhes.portfolio.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "membros")
public class Membros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idprojeto", nullable = false)
    private Projeto projeto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idpessoa", nullable = false)
    private Pessoa pessoa;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String atribuicao;
}
