package br.com.example.app.exception;

public class NumDocumentoException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public NumDocumentoException() {
        super("O Número do Documento não foi preenchido corretamente!");
    }
}
