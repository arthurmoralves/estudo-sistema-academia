package br.com.projeto.academia.mapper;

import br.com.projeto.academia.br.com.projeto.academia.dto.FuncionarioDto;
import br.com.projeto.academia.entity.FuncionarioEntity;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

@Service
public class FuncionarioMapper {

    private FuncionarioMapper() {
        super();
    }

    ModelMapper modelMapper = new ModelMapper();

    public FuncionarioDto marshall(FuncionarioEntity funcionarioEntity) {
        return modelMapper.map(funcionarioEntity, FuncionarioDto.class);
    }

    public FuncionarioEntity unmarshall(FuncionarioDto funcionario) {
        return modelMapper.map(funcionario, FuncionarioEntity.class);
    }

    public Page<FuncionarioDto> converter(Page<FuncionarioEntity> funcionariosEntity) {
        return funcionariosEntity.map(FuncionarioDto::new);
    }

}
