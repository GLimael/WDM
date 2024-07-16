package net.weg.wdm.wdm.controller.dto.reserva;

import net.weg.wdm.wdm.entity.Ambiente;
import net.weg.wdm.wdm.entity.DispositivoReservado;
import net.weg.wdm.wdm.entity.Periodo;
import net.weg.wdm.wdm.entity.Turma;

import java.time.LocalDate;
import java.util.List;

public record ReservaResponseDTO(
        String status,
        Ambiente ambiente,
        Turma turma,
        Periodo periodo,
        LocalDate dia,
        String comentario,
        Long numero,
        List<DispositivoReservado> dispositivosReservados
) {
}
