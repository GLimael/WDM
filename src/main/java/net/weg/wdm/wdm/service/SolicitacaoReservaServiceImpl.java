package net.weg.wdm.wdm.service;

import lombok.AllArgsConstructor;
import net.weg.wdm.wdm.controller.dto.reserva.PeriodoReservaRequestDTO;
import net.weg.wdm.wdm.controller.dto.reserva.ReservaRequestPostDTO;
import net.weg.wdm.wdm.entity.*;
import net.weg.wdm.wdm.repository.SolicitacaoReservaRepository;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
public class SolicitacaoReservaServiceImpl implements SolicitacaoReservaServiceInt {

    private final DispositivoServiceImpl dispositivoService;
    private final SolicitacaoReservaRepository repository;

    @Override
    public SolicitacaoReserva criarSolicitacaoReserva(ReservaRequestPostDTO reservaDTO) {
        SolicitacaoReserva solicitacaoReserva = new SolicitacaoReserva();
        repository.save(solicitacaoReserva);
        Map<TipoDispositivo, List<Dispositivo>> dispositivos = dispositivoService.
                buscarDispositivosPorIdSeparadosPorTipo(reservaDTO.getIdDispositivos());
        Set<TipoDispositivo> tipos = dispositivos.keySet();
        List<Reserva> reservas = new ArrayList<>();
        solicitacaoReserva.setReservas(reservas);
        LocalDate data = reservaDTO.getInicio();
        do {
            DayOfWeek diaDaSemana = data.getDayOfWeek();
            for (PeriodoReservaRequestDTO periodoDTO : reservaDTO.getPeriodos()) {
                if (periodoDTO.getDiaSemana().ordinal() == diaDaSemana.ordinal()) {
                    for (TipoDispositivo tipo : tipos) {
                        Reserva reserva = criarReserva(reservaDTO, periodoDTO, data,solicitacaoReserva);
                        reservas.add(reserva);
                        repository.save(solicitacaoReserva);
                        criarDipositivosReservado(dispositivos, reserva, tipo);
                        repository.save(solicitacaoReserva);
                    }
                }
            }
            data = data.plusDays(1);
        } while (data.isBefore(reservaDTO.getFim().plusDays(1)));
        return solicitacaoReserva;
//        criarDipositivosReservado(dispositivos, solicitacaoReserva);
    }

    private Reserva criarReserva(ReservaRequestPostDTO reservaDTO,
                                 PeriodoReservaRequestDTO periodoDTO, LocalDate data,
                                 SolicitacaoReserva solicitacaoReserva) {
        Reserva reserva = new Reserva();
        reserva.setSolicitacao(solicitacaoReserva);
        reserva.setSolicitante(new Usuario(reservaDTO.getIdUsuario()));
        reserva.setDia(data);
        reserva.setStatus(StatusReserva.EM_ABERTO);
        reserva.setPeriodo(new Periodo(periodoDTO.getIdPeriodo()));
        reserva.setAmbiente(new Ambiente(periodoDTO.getIdAmbiente()));
        reserva.setTurma(new Turma(reservaDTO.getIdTurma()));
        return reserva;
    }

    private void criarDipositivosReservado(Map<TipoDispositivo, List<Dispositivo>> dispositivos,
                                           Reserva reserva, TipoDispositivo tipo) {
        reserva.setDispositivosReservado(dispositivos.get(tipo).stream().
                map(dispositivo -> new DispositivoReservado(dispositivo, reserva)).toList());
    }
}
