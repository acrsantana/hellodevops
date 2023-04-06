package br.com.acrtech.hellodevops.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class UsuarioDto {
    private String cpf;
    private String nome;
    private Sexo sexo;
}
