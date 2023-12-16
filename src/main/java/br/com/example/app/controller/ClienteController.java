package br.com.example.app.controller;

import br.com.example.app.model.Cliente;
import br.com.example.app.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

// @RequestMapping("/api/v1/clientes")
@RestController
@RequestMapping("/")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<Collection<Cliente>> listar() {
        return ResponseEntity.ok().body(clienteService.obterLista());
    }

    @PostMapping
    public ResponseEntity<Cliente> incluir(@RequestBody Cliente novoCliente) {
        clienteService.incluir(novoCliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoCliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable Long id) {
        clienteService.excluir(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
            .body("Cliente com o id: %d foi deletado!".formatted(id));
        //
    }
}
