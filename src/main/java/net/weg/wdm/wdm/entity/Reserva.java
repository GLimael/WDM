package net.weg.wdm.wdm.entity;

import jakarta.persistence.*;
import lombok.*;
import net.weg.wdm.wdm.controller.dto.periodo.PeriodoReservaRequestPostDTO;
import net.weg.wdm.wdm.controller.dto.reserva.ReservaResponseDTO;
import net.weg.wdm.wdm.controller.dto.solicitacao.SolicitacaoReservaRequestPostDTO;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numero;
    @ManyToOne
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_reserva")
    private List<DispositivoReservado> dispositivosReservado;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusReserva status;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Ambiente ambiente;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Turma turma;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Periodo periodo;
    @Column(nullable = false)
    private LocalDate dia;
    private String comentario;

    public Reserva(SolicitacaoReservaRequestPostDTO reservaDTO,
                   PeriodoReservaRequestPostDTO periodoDTO, LocalDate data,
                   List<DispositivoReservado> dispositivos) {
        this.setDia(data);
        this.setStatus(StatusReserva.EM_ABERTO);
        this.setPeriodo(new Periodo(periodoDTO.idPeriodo()));
        this.setAmbiente(new Ambiente(periodoDTO.idAmbiente()));
        this.setTurma(new Turma(reservaDTO.idTurma()));
        this.setDispositivosReservado(dispositivos);
    }

    public ReservaResponseDTO toDTO() {
        return new ReservaResponseDTO(this.status.getNOME(), this.ambiente, this.turma,
                this.periodo, this.dia, this.comentario, this.numero,
                this.dispositivosReservado);
    }
}

