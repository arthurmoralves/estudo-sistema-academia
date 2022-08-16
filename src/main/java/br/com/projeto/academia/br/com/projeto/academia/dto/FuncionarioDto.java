package br.com.projeto.academia.br.com.projeto.academia.dto;

import br.com.projeto.academia.entity.FuncionarioEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.Embedded;
import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class FuncionarioDto {

    private Long id;

    @Embedded
    private CpfDto cpf;

    private String nome;

    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate dataNasc;
    private String cargo;
    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate dataContratacao;
    private BigDecimal salario;
    private EnderecoDto endereco;

    public FuncionarioDto(FuncionarioEntity funcionarioEntity) {
        this.id = funcionarioEntity.getId();
        this.cpf = new CpfDto(funcionarioEntity.getCpf());
        this.nome = funcionarioEntity.getNome();
        this.dataNasc = funcionarioEntity.getDataNasc();
        this.cargo = funcionarioEntity.getCargo();
        this.dataContratacao = funcionarioEntity.getDataContratacao();
        this.salario = funcionarioEntity.getSalario();
        this.endereco = new EnderecoDto(funcionarioEntity.getEndereco());
    }
}
