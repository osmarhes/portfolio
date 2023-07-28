package br.com.osmarhes.portfolio.controller;

import br.com.osmarhes.portfolio.dto.MembroDTO;
import br.com.osmarhes.portfolio.dto.MembroRequest;
import br.com.osmarhes.portfolio.service.MembroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/membros")
@RequiredArgsConstructor
public class MembroController {

    private final MembroService projetoService;

    @PostMapping("/{idProjeto}/pessoa/{idPessoa}")
    public ResponseEntity<MembroDTO> adicionarMembroAoProjeto(
            @PathVariable Long idProjeto,
            @PathVariable Long idPessoa,
            @RequestBody MembroRequest membroRequest) {

        MembroDTO membroDTO = projetoService.adicionarMembroAoProjeto(idProjeto, idPessoa, membroRequest);
        return new ResponseEntity<>(membroDTO, HttpStatus.OK);
    }
}