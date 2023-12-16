package br.com.example.app;

import br.com.example.app.desafios.NumeroPrimo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NumeroPrimoTest {

    private NumeroPrimo numeroPrimo;

    public NumeroPrimoTest() {
        this.numeroPrimo = new NumeroPrimo();
    }

    @Test
    void shouldBeNotNull() {
        Assertions.assertNotNull(numeroPrimo.calculaNumeroPrimo(2));
    }

    @Test
    void shouldBeAnInstanceOfInteger() {
        Assertions.assertInstanceOf(String.class, numeroPrimo.calculaNumeroPrimo(Integer.parseInt("2")));
    }

    @Test
    void shouldBeNotAString() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            numeroPrimo.calculaNumeroPrimo(Integer.parseInt("Test"));
        });
    }

    @Test
    void shouldBeAPositiveNumber() {
        ArithmeticException thrown = Assertions.assertThrows(ArithmeticException.class, () -> {
            numeroPrimo.calculaNumeroPrimo(-1);
        });
        Assertions.assertEquals("Está errado! Não use números negativos, zero ou um!", thrown.getMessage());
    }

    @Test
    void shouldBeNotEqualsOne() {
        ArithmeticException thrown = Assertions.assertThrows(ArithmeticException.class, () -> {
            numeroPrimo.calculaNumeroPrimo(1);
        });
        Assertions.assertEquals("Está errado! Não use números negativos, zero ou um!", thrown.getMessage());
    }

    @Test
    void shouldBeNotLessThanOne() {
        ArithmeticException thrown = Assertions.assertThrows(ArithmeticException.class, () -> {
            numeroPrimo.calculaNumeroPrimo(1);
        });
        Assertions.assertEquals("Está errado! Não use números negativos, zero ou um!", thrown.getMessage());
    }


    @ParameterizedTest
    @ValueSource(ints = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97})
    void shouldSendAnOKMessageIfDivisibleByItself(int number) {
        Assertions.assertEquals("É um número primo.", numeroPrimo.calculaNumeroPrimo(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 6, 8, 10, 20, 25, 26, 30, 33, 34})
    void shouldSendANOKMessageIfDivisibleByMoreThanOne(int number) {
        Assertions.assertEquals("Não é um número primo.", numeroPrimo.calculaNumeroPrimo(number));
    }
}
