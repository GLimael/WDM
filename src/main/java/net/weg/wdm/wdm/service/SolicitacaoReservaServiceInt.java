package net.weg.wdm.wdm.service;

import net.weg.wdm.wdm.controller.dto.reserva.ReservaRequestPostDTO;
import net.weg.wdm.wdm.entity.SolicitacaoReserva;
import org.springframework.stereotype.Service;

@Service
public interface SolicitacaoReservaServiceInt {
    SolicitacaoReserva criarSolicitacaoReserva(ReservaRequestPostDTO requestDTO);
}
