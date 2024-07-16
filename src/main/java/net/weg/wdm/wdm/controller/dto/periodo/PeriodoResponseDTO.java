package net.weg.wdm.wdm.controller.dto.periodo;

import net.weg.wdm.wdm.entity.Ambiente;
import net.weg.wdm.wdm.entity.Periodo;

public record PeriodoResponseDTO(
        Periodo periodo,
        Ambiente ambiente,
        String diaSemana
) {
}
