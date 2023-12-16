package br.com.example.app.contract;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ClienteTest implements TestBase {

    @Test
    @Override
    public void shouldBeACorrectPartialSchema() {
        var wherever = false;
        assertThat(wherever).isFalse();
    }

    @Test
    @Override
    public void shouldBeACorrectSchema() {
    }

    @Test
    @Override
    public void shouldBeACorrectObjectType() {
    }
}
