package net.weg.wdm.wdm.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.wdm.wdm.controller.dto.periodo.PeriodoReservaRequestPostDTO;
import net.weg.wdm.wdm.controller.dto.periodo.PeriodoResponseDTO;
import net.weg.wdm.wdm.controller.dto.reserva.ReservaResponseDTO;
import net.weg.wdm.wdm.controller.dto.solicitacao.SolicitacaoReservaRequestPostDTO;
import net.weg.wdm.wdm.controller.dto.solicitacao.SolicitacaoReservaResponseDTO;
import net.weg.wdm.wdm.controller.dto.solicitacao.SolicitacaoResponseDTO;
import org.springframework.cglib.core.Local;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class SolicitacaoReserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_solicitacao")
    private List<Reserva> reservas;
    @ManyToOne
    private Usuario solicitante;

    public SolicitacaoReserva(SolicitacaoReservaRequestPostDTO reservaDTO, Map<TipoDispositivo, List<Dispositivo>> dispositivos) {
        Set<TipoDispositivo> tipos = dispositivos.keySet();
        List<Reserva> reservas = new ArrayList<>();
        this.setReservas(reservas);
        this.solicitante = new Usuario(reservaDTO.idUsuario());
        LocalDate data = reservaDTO.inicio();
        do {
            for (PeriodoReservaRequestPostDTO periodoDTO : reservaDTO.periodos()) {
                DayOfWeek diaDaSemana = data.getDayOfWeek();
                if (periodoDTO.diaSemana().ordinal() == diaDaSemana.ordinal()) {
                    for (TipoDispositivo tipo : tipos) {
                        List<DispositivoReservado> dispositivoReservados = dispositivos.get(tipo).stream().
                                map(dispositivo -> new DispositivoReservado(dispositivo)).toList();
                        Reserva reserva = new Reserva(reservaDTO, periodoDTO, data, dispositivoReservados);
                        reservas.add(reserva);
                    }
                }
            }
            data = data.plusDays(1);
        } while (data.isBefore(reservaDTO.fim().plusDays(1)));
    }

    public SolicitacaoReservaResponseDTO paraDTO() {
        List<ReservaResponseDTO> reservasDTO = this.reservas.stream()
                .map(reserva -> reserva.toDTO()).toList();
        return new SolicitacaoReservaResponseDTO(this.id, reservasDTO);
    }

    public SolicitacaoResponseDTO paraOutroDTO() {
        Reserva reserva = this.getReservas().get(0);
        Set<Dispositivo> dispositivos = new HashSet<>();
        LocalDate inicio = reserva.getDia();
        LocalDate fim = reserva.getDia();

        List<PeriodoResponseDTO> periodosDTO = new ArrayList<>();

        for(Reserva reserva1 : this.getReservas()) {
            if(inicio.isAfter(reserva1.getDia())) {
                inicio = reserva1.getDia();
            }
            if(fim.isBefore(reserva1.getDia())) {
                fim = reserva1.getDia();
            }
            Periodo periodo;
            Ambiente ambiente;
            String diaSemana = "";
            for(DispositivoReservado dispositivoReservado : reserva1.getDispositivosReservado()) {
                dispositivos.add(dispositivoReservado.getDispositivo());
            }
            periodo = (reserva1.getPeriodo());
            ambiente = (reserva1.getAmbiente());
            for(DiaSemana semana : DiaSemana.values()) {
                if (semana.ordinal() == reserva1.getDia().getDayOfWeek().ordinal()) {
                    diaSemana = (semana.getNOME());
                    break;
                }
            }
            periodosDTO.add(new PeriodoResponseDTO(
                    periodo, ambiente, diaSemana
            ));
        }


        return new SolicitacaoResponseDTO(
                this.solicitante,
                reserva.getTurma(),
                new ArrayList<>(dispositivos),
                periodosDTO,
                inicio,
                fim
        );
    }
}
