package br.com.example.app.desafios;

import java.util.stream.IntStream;

import static java.lang.System.out;

public class NumeroPrimo {

    public String calculaNumeroPrimo(int numero) {

        String msg = "É um número primo.";

        int $numero = Integer.parseInt(String.valueOf(numero));
        boolean maiorQueUm = isMaiorQueUm($numero);
        numero = $numero / 2;
        //
        if (maiorQueUm && IntStream.rangeClosed(2, numero).anyMatch(i -> $numero % i == 0))
            msg = "Não é um número primo.";
        //
        return msg;
    }

    private boolean isMaiorQueUm(int numero) {
        if (numero > 1)
            return true;
        else
            throw new ArithmeticException("Está errado! Não use números negativos, zero ou um!");
    }

    public static void main(String[] args) {
        out.println("\n" + new NumeroPrimo().calculaNumeroPrimo(2));
    }
}
