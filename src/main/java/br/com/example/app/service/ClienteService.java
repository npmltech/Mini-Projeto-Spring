package br.com.example.app.service;

import br.com.example.app.exception.NumDocumentoException;
import br.com.example.app.model.Cliente;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class ClienteService {

    private Long id;
    private Map<Long, Cliente> mapaCliente;

    private final Logger LOGGER = LoggerFactory.getLogger(ClienteService.class);

    public ClienteService() {
        this.id = 0L;
        this.mapaCliente = new HashMap<>();
    }

    public void incluir(Cliente cliente) {
        id++;
        cliente.setId(this.id);
        if (String.valueOf(cliente.getNumeroDocumento()).length() < 5) throw new NumDocumentoException();
        this.mapaCliente.put(cliente.getId(), cliente);
        LOGGER.info(
            "[Cliente] Inclusão realizada com sucesso: %s.".formatted(cliente)
        );
    }

    public Collection<Cliente> obterLista() {
        if (!this.mapaCliente.values().isEmpty()) {
            LOGGER.info("[Cliente] Lista de clientes retornada com sucesso!");
            return this.mapaCliente.values();
        }
        return Collections.emptyList();
    }

    public void excluir(Long id) {
        this.mapaCliente.remove(id);
        LOGGER.info(
            "Cliente com o id: %d foi deletado!".formatted(id)
        );
    }
}
