package br.com.example.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Component
public class Cliente {

    private Long id;
    private String nome;
    private Long numeroDocumento;
    private String observacao;
    private Boolean ativo;
}