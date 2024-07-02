package net.weg.wdm.wdm.entity;

import jakarta.persistence.*;
import lombok.*;

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
    @Column(nullable = false)
    private Usuario solicitante;
    @OneToMany(mappedBy = "reserva", cascade = CascadeType.ALL)
    private List<DispositivoReservado> dispositivosReservado;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusReserva status;
    @ManyToOne
    @Column(nullable = false)
    private Ambiente ambiente;
    @ManyToOne
    @Column(nullable = false)
    private Turma turma;
    @ManyToOne
    @Column(nullable = false)
    private Periodo periodo;
    @Column(nullable = false)
    private LocalDate dia;
    @ManyToOne
    @Column(nullable = false)
    private SolicitacaoReserva solicitacao;
    private String comentario;
}

