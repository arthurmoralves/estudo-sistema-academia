package br.com.projeto.academia.entity;

import br.com.projeto.academia.br.com.projeto.academia.dto.CpfDto;
import br.com.projeto.academia.br.com.projeto.academia.dto.EnderecoDto;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@DynamicInsert
public class FuncionarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "funcionario_id")
    private Long id;

    private String cpf;

    private String nome;
    private LocalDate dataNasc;
    private String cargo;
    private LocalDate dataContratacao;
    private BigDecimal salario;

    @ManyToOne
    private EnderecoEntity endereco;
}
