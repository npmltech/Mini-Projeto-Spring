package br.com.example.app.loader;

import br.com.example.app.model.Cliente;
import br.com.example.app.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

@Order(1)
@Component
public class ClienteLoader implements ApplicationRunner {

    private static final String WIN_PATH = "\\files\\clientes.txt";
    private static final String LINUX_PATH = "/files/clientes.txt";
    private static final String OS = System.getProperty("os.name");

    private Cliente cliente;
    private String[] campos;
    private final Map<Long, Cliente> mapaCliente;

    @Autowired
    private ClienteService clienteService;

    public ClienteLoader() {
        this.mapaCliente = new HashMap<>();
        this.campos = new String[0];
    }

    private String devolveDirPorSisOperacional() {
        return OS.contains("win") ? WIN_PATH : LINUX_PATH;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Path resourceMainDir = Paths.get("src", "main", "resources");
        String absolutePath = resourceMainDir.toFile().getAbsolutePath();

        try (BufferedReader leitura = new BufferedReader(
            new FileReader(
                absolutePath.concat(devolveDirPorSisOperacional()),
                StandardCharsets.UTF_8
            )
        )) {
            //
            String linha = leitura.readLine();
            //
            while (linha != null) {
                this.campos = linha.split(";");
                this.cliente = new Cliente(
                    Long.valueOf(campos[0]),
                    campos[1],
                    Long.valueOf(campos[2]),
                    campos[3],
                    Boolean.valueOf(campos[4])
                );
                this.clienteService.incluir(this.cliente);

                linha = leitura.readLine();
            }
        }
    }
}
