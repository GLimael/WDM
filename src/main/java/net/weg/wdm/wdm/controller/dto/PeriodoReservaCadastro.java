package net.weg.wdm.wdm.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import net.weg.wdm.wdm.entity.DiaSemana;

@AllArgsConstructor
@Data
public class PeriodoReservaCadastro {
    private Long idPeriodo;
    private Long idAmbiente;
    private DiaSemana diaSemana;
}
