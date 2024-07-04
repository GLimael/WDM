package net.weg.wdm.wdm.controller.dto.reserva;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Data
public class ReservaRequestPostDTO {
    private Long idUsuario;
    private Long idTurma;
    private List<Long> idDispositivos;
    private List<PeriodoReservaCadastroRequestDTO> periodos;
    private LocalDate inicio;
    private LocalDate fim;
}
