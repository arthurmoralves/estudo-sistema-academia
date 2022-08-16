package br.com.projeto.academia.br.com.projeto.academia.dto;

import br.com.projeto.academia.exception.CPFInvalidException;
import lombok.*;

import java.util.InputMismatchException;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Builder
public class CpfDto {

    private String cpf;

    public CpfDto(String cpf){
        this.cpf = cpf;
        validateCpf();
    }

    private void validateCpf(){
        if (!this.isCPFValido())
            throw new CPFInvalidException("CPF inválido");
    }

    public boolean isCPFValido() {
        if (this.cpf.equals("00000000000") ||
                this.cpf.equals("11111111111") ||
                this.cpf.equals("22222222222") || this.cpf.equals("33333333333") ||
                this.cpf.equals("44444444444") || this.cpf.equals("55555555555") ||
                this.cpf.equals("66666666666") || this.cpf.equals("77777777777") ||
                this.cpf.equals("88888888888") || this.cpf.equals("99999999999") ||
                (this.cpf.length() != 11))
            return(false);

        char dig10, dig11;
        Integer soma, i, razao, num, peso;

        try {
            soma = 0;
            peso = 10;
            for (i=0; i<9; i++) {
                num = (Integer)(this.cpf.charAt(i) - 48);
                soma = soma + (num * peso);
                peso = peso - 1;
            }

            razao = 11 - (soma % 11);
            if ((razao == 10) || (razao == 11))
                dig10 = '0';
            else dig10 = (char)(razao + 48);
            soma = 0;
            peso = 11;
            for(i=0; i<10; i++) {
                num = (Integer)(this.cpf.charAt(i) - 48);
                soma = soma + (num * peso);
                peso = peso - 1;
            }

            razao = 11 - (soma % 11);
            if ((razao == 10) || (razao == 11))
                dig11 = '0';
            else dig11 = (char)(razao + 48);

            if ((dig10 == this.cpf.charAt(9)) && (dig11 == this.cpf.charAt(10)))
                return(true);
            else return(false);
        } catch (InputMismatchException erro) {
            return(false);
        }
    }

    public String retornaCpfComMascara() {
        return(this.cpf.substring(0, 3) + "." + this.cpf.substring(3, 6) + "." +
                this.cpf.substring(6, 9) + "-" + this.cpf.substring(9, 11));
    }
}
