package br.com.projeto.academia.exception;

public class CPFInvalidException extends RuntimeException {
    public CPFInvalidException(String message) {
        super(message);
    }
}
