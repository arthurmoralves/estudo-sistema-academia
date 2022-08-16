package br.com.projeto.academia.mapper;

import br.com.projeto.academia.br.com.projeto.academia.dto.EnderecoDto;
import br.com.projeto.academia.entity.EnderecoEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class EnderecoMapper {

    private EnderecoMapper() {
        super();
    }

    ModelMapper modelMapper = new ModelMapper();

    public EnderecoDto marshall(EnderecoEntity enderecoEntity) {
        return modelMapper.map(enderecoEntity, EnderecoDto.class);
    }

    public EnderecoEntity unmarshall(EnderecoDto endereco) {
        return modelMapper.map(endereco, EnderecoEntity.class);
    }
}
