package br.com.osmarhes.portfolio.dto;

import br.com.osmarhes.portfolio.model.enuns.Risco;
import br.com.osmarhes.portfolio.model.enuns.StatusProjeto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ProjetoDTO {
    private Long id;
    private String nome;
    private LocalDate dataInicio;
    private LocalDate dataPrevisaoFim;
    private LocalDate dataFim;
    private String descricao;
    private StatusProjeto status;
    private Float orcamento;
    private Risco risco;
    private Long idGerente;

}
