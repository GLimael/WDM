package net.weg.wdm.wdm.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TipoUsuario {
    USUARIO("Usuário"),
    ADIMINISTRADOR("Administrador");

    private final String NOME;
}
