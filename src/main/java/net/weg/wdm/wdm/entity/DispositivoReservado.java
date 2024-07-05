package net.weg.wdm.wdm.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class DispositivoReservado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Dispositivo dispositivo;
    private LocalDateTime retirada;
    private LocalDateTime devolucao;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Reserva reserva;

}
