package br.com.osmarhes.portfolio.service;
import br.com.osmarhes.portfolio.dto.ProjetoDTO;
import br.com.osmarhes.portfolio.model.Projeto;
import br.com.osmarhes.portfolio.model.Pessoa;
import br.com.osmarhes.portfolio.model.enuns.StatusProjeto;
import br.com.osmarhes.portfolio.repository.PessoaRepository;
import br.com.osmarhes.portfolio.repository.ProjetoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProjetoService {

    private final ProjetoRepository projetoRepository;
    private final PessoaRepository pessoaRepository;

    @Transactional
    public ProjetoDTO criarProjeto(ProjetoDTO projetoDTO) {
        Projeto projeto = new Projeto();
        updateProjetoFromDTO(projeto, projetoDTO);
        projeto = projetoRepository.save(projeto);
        projetoDTO.setId(projeto.getId());
        return projetoDTO;
    }

    @Transactional
    public ProjetoDTO atualizarProjeto(Long id, ProjetoDTO projetoDTO) {
        Projeto projeto = projetoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Projeto não encontrado com ID: " + id));
        updateProjetoFromDTO(projeto, projetoDTO);
        return projetoDTO;
    }

    @Transactional
    public void excluirProjeto(Long id) {
        Projeto projeto = projetoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Projeto não encontrado com ID: " + id));

        if (projeto.getStatus() == StatusProjeto.INICIADO ||
                projeto.getStatus() == StatusProjeto.EM_ANDAMENTO ||
                projeto.getStatus() == StatusProjeto.ENCERRADO) {
            throw new IllegalArgumentException("Não é possível excluir um projeto com status 'Iniciado', 'Em Andamento' ou 'Encerrado'.");
        }

        projetoRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public ProjetoDTO consultarProjeto(Long id) {
        Projeto projeto = projetoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Projeto não encontrado com ID: " + id));
        return createProjetoDTOFromEntity(projeto);
    }

    private void updateProjetoFromDTO(Projeto projeto, ProjetoDTO projetoDTO) {
        BeanUtils.copyProperties(projetoDTO, projeto, "idGerente");
        if (projetoDTO.getIdGerente() != null) {
            Pessoa gerente = pessoaRepository.findById(projetoDTO.getIdGerente())
                    .orElseThrow(() -> new IllegalArgumentException("Gerente não encontrado com ID: " + projetoDTO.getIdGerente()));
            projeto.setGerente(gerente);
        }
    }

    private ProjetoDTO createProjetoDTOFromEntity(Projeto projeto) {
        ProjetoDTO projetoDTO = new ProjetoDTO();
        BeanUtils.copyProperties(projeto, projetoDTO, "gerente");
        if (projeto.getGerente() != null) {
            projetoDTO.setIdGerente(projeto.getGerente().getId());
        }
        return projetoDTO;
    }
}