package net.weg.wdm.wdm.controller.dto.periodo;

import net.weg.wdm.wdm.entity.DiaSemana;

public record PeriodoReservaRequestPostDTO(
        Long idPeriodo,
        Long idAmbiente,
        DiaSemana diaSemana
) {
}
