package br.com.projeto.academia.br.com.projeto.academia.dto;

import br.com.projeto.academia.entity.EnderecoEntity;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class EnderecoDto {

    private Long id;
    private String cep;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String uf;
    private Integer numero;
    private String complemento;

    public EnderecoDto(EnderecoEntity enderecoEntity) {
        this.id = enderecoEntity.getId();
        this.cep = enderecoEntity.getCep();
        this.logradouro = enderecoEntity.getLogradouro();
        this.bairro = enderecoEntity.getBairro();
        this.cidade = enderecoEntity.getCidade();
        this.uf = enderecoEntity.getUf();
        this.numero = enderecoEntity.getNumero();
        this.complemento = enderecoEntity.getComplemento();
    }
    
}
