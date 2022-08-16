package br.com.projeto.academia.service;

import br.com.projeto.academia.br.com.projeto.academia.dto.FuncionarioDto;
import br.com.projeto.academia.mapper.EnderecoMapper;
import br.com.projeto.academia.mapper.FuncionarioMapper;
import br.com.projeto.academia.repository.EnderecoRepository;
import br.com.projeto.academia.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private FuncionarioMapper funcionarioMapper;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private EnderecoMapper enderecoMapper;

    public Page<FuncionarioDto> consultar(Pageable page) {
        var listaFuncionario = funcionarioRepository.findAll(page);
        return funcionarioMapper.converter(listaFuncionario);
    }

    public FuncionarioDto remover(String cpf) {
        var funcionario = funcionarioRepository.findByCpf(cpf);
        if (funcionario.isPresent()) {
            funcionarioRepository.delete(funcionario.get());
            return funcionarioMapper.marshall(funcionario.get());
        } else {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Funcionario não encontrado");
        }
    }

    public FuncionarioDto incluir(FuncionarioDto funcionario) {
        var funcionarioEntity = funcionarioMapper.unmarshall(funcionario);
        enderecoRepository.save(funcionarioEntity.getEndereco());
        return funcionarioMapper.marshall(funcionarioRepository.save(funcionarioEntity));
    }

    public FuncionarioDto alterar(FuncionarioDto funcionario) {
        var funcionarioUpdate = funcionarioMapper.unmarshall(funcionario);
        var enderecoUpdate = enderecoMapper.unmarshall(funcionario.getEndereco());
        enderecoRepository.save(enderecoUpdate);
        return funcionarioMapper.marshall(funcionarioRepository.save(funcionarioUpdate));
    }
}
