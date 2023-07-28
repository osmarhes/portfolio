package br.com.osmarhes.portfolio.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;


@Getter
@Setter
@Entity
@Table(name = "pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column
    private LocalDate dataNascimento;

    @Column(length = 14)
    private String cpf;

    @Column
    private Boolean funcionario;


}