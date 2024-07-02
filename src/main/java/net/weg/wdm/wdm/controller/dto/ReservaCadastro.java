package net.weg.wdm.wdm.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import net.weg.wdm.wdm.entity.DiaSemana;
import net.weg.wdm.wdm.entity.Dispositivo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Data
public class ReservaCadastro {
    private Long idUsuario;
    private Long idTurma;
    private List<Long> idDispositivos;
    private List<PeriodoReservaCadastro> periodos;
    private LocalDate inicio;
    private LocalDate fim;
}
