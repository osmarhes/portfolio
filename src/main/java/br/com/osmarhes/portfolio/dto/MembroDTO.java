package br.com.osmarhes.portfolio.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MembroDTO {

    private ProjetoDTO projetoDTO;
    private PessoaDTO pessoaDTO;
    private String atribuicao;
}
