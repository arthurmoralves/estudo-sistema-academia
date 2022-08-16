package br.com.projeto.academia.controller;

import br.com.projeto.academia.br.com.projeto.academia.dto.FuncionarioDto;
import br.com.projeto.academia.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/academia")
public class AcademiaController {

    @Autowired
    FuncionarioService funcionarioService;

    @GetMapping("/funcionarios/consultar")
    public Page<FuncionarioDto> consultarFuncionario(@RequestParam int pag, int qtd) {
        Pageable page = PageRequest.of(pag, qtd);
        return funcionarioService.consultar(page);
    }

    @DeleteMapping("/funcionarios/remover")
    public ResponseEntity<FuncionarioDto> deletar(@RequestBody String cpf) {
            return ResponseEntity.ok(funcionarioService.remover(cpf));
    }

    @PostMapping("/funcionarios/incluir")
    public ResponseEntity<FuncionarioDto> inserir(@RequestBody FuncionarioDto funcionario) {
        return ResponseEntity.ok(funcionarioService.incluir(funcionario));
    }

    @PutMapping("/funcionarios/alterar")
    public ResponseEntity<FuncionarioDto> alterar(@RequestBody FuncionarioDto funcionarioDto) {
        return ResponseEntity.ok(funcionarioService.alterar(funcionarioDto));
    }
}
