package net.weg.wdm.wdm.controller.dto.solicitacao;

import net.weg.wdm.wdm.controller.dto.periodo.PeriodoResponseDTO;
import net.weg.wdm.wdm.entity.Dispositivo;
import net.weg.wdm.wdm.entity.Turma;
import net.weg.wdm.wdm.entity.Usuario;

import java.time.LocalDate;
import java.util.List;

public record SolicitacaoResponseDTO(
        Usuario solicitante,
        Turma turma,
        List<Dispositivo> disitivos,
        List<PeriodoResponseDTO> periodos,
        LocalDate inicio,
        LocalDate fim
) {
}
