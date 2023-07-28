package br.com.osmarhes.portfolio.controller;

import br.com.osmarhes.portfolio.dto.ProjetoDTO;
import br.com.osmarhes.portfolio.service.ProjetoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {

    private final ProjetoService projetoService;

    public ProjetoController(ProjetoService projetoService) {
        this.projetoService = projetoService;
    }

    @PostMapping
    public ResponseEntity<ProjetoDTO> criarProjeto(@RequestBody ProjetoDTO projetoDTO) {
        projetoDTO = projetoService.criarProjeto(projetoDTO);
        return new ResponseEntity<>(projetoDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjetoDTO> atualizarProjeto(@PathVariable Long id, @RequestBody ProjetoDTO projetoDTO) {
        projetoDTO = projetoService.atualizarProjeto(id, projetoDTO);
        return new ResponseEntity<>(projetoDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirProjeto(@PathVariable Long id) {
        projetoService.excluirProjeto(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjetoDTO> consultarProjeto(@PathVariable Long id) {
        ProjetoDTO projetoDTO = projetoService.consultarProjeto(id);
        return new ResponseEntity<>(projetoDTO, HttpStatus.OK);
    }
}
