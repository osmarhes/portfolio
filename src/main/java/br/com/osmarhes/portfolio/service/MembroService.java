package br.com.osmarhes.portfolio.service;

import br.com.osmarhes.portfolio.dto.MembroDTO;
import br.com.osmarhes.portfolio.dto.MembroRequest;
import br.com.osmarhes.portfolio.model.Membros;
import br.com.osmarhes.portfolio.model.Pessoa;
import br.com.osmarhes.portfolio.model.Projeto;
import br.com.osmarhes.portfolio.repository.MembrosRepository;
import br.com.osmarhes.portfolio.repository.PessoaRepository;
import br.com.osmarhes.portfolio.repository.ProjetoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class MembroService {

    private final ProjetoRepository projetoRepository;
    private final PessoaRepository pessoaRepository;
    private final MembrosRepository membrosRepository;

    @Transactional
    public MembroDTO adicionarMembroAoProjeto(Long idProjeto, Long idPessoa, MembroRequest membroRequest) {
        Projeto projeto = projetoRepository.findById(idProjeto)
                .orElseThrow(() -> new IllegalArgumentException("Projeto não encontrado com ID: " + idProjeto));

        Pessoa pessoa = pessoaRepository.findById(idPessoa)
                .orElseThrow(() -> new IllegalArgumentException("Pessoa não encontrada com ID: " + idPessoa));


        if (!pessoa.getFuncionario()) {
            throw new IllegalArgumentException("Apenas membros com atribuição 'funcionário' podem ser associados ao projeto.");
        }

        Membros membro = new Membros();
        membro.setProjeto(projeto);
        membro.setPessoa(pessoa);
        membro.setNome(membroRequest.getNome());
        membro.setAtribuicao(membroRequest.getAtribuicao());

        membrosRepository.save(membro);
        MembroDTO membroDTO = new MembroDTO();
        BeanUtils.copyProperties(membro, membroDTO);
        return membroDTO;
    }

}
