package br.com.example.app;

import br.com.example.app.controller.ClienteController;
import br.com.example.app.loader.ClienteLoader;
import br.com.example.app.model.Cliente;
import br.com.example.app.service.ClienteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SmokeTest {

    @Autowired
    Cliente cliente;

    @Autowired
    ClienteLoader clienteLoader;

    @Autowired
    ClienteService clienteService;

    @Autowired
    ClienteController clienteController;

    @Test
    void contextLoads() {
        assertThat(cliente).isNotNull();
        assertThat(clienteLoader).isNotNull();
        assertThat(clienteService).isNotNull();
        assertThat(clienteController).isNotNull();
    }
}
