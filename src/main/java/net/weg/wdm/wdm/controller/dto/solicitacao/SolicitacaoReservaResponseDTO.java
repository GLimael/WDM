package net.weg.wdm.wdm.controller.dto.solicitacao;

import net.weg.wdm.wdm.controller.dto.reserva.ReservaResponseDTO;

import java.util.List;

public record SolicitacaoReservaResponseDTO(
        Long id,
        List<ReservaResponseDTO> reservas
) {
}
