package net.weg.wdm.wdm.service;

import net.weg.wdm.wdm.controller.dto.reserva.PeriodoReservaRequestDTO;
import net.weg.wdm.wdm.controller.dto.reserva.ReservaRequestPostDTO;
import net.weg.wdm.wdm.entity.SolicitacaoReserva;

import java.time.LocalDate;

public class SolicitacaoReservaServiceImpl implements SolicitacaoReservaServiceInt{

    @Override
    public SolicitacaoReserva criarReservas(ReservaRequestPostDTO reservaDTO) {
        SolicitacaoReserva solicitacaoReserva;

        LocalDate data = reservaDTO.getInicio();
        do {
            for(PeriodoReservaRequestDTO periodoDTO : reservaDTO.getPeriodos()) {
                for(Long idDispositivo : reservaDTO.getIdDispositivos()) {

                }
            }
            data = data.plusDays(1);
        }while(data.isBefore(reservaDTO.getFim().plusDays(1)));

        return solicitacaoReserva;
    }
}
