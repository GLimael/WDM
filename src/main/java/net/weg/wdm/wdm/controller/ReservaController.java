package net.weg.wdm.wdm.controller;

import lombok.AllArgsConstructor;
import net.weg.wdm.wdm.controller.dto.reserva.ReservaRequestPostDTO;
import net.weg.wdm.wdm.entity.SolicitacaoReserva;
import net.weg.wdm.wdm.service.ReservaServiceInt;
import net.weg.wdm.wdm.service.SolicitacaoReservaServiceInt;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/reserva")
public class ReservaController {
    private SolicitacaoReservaServiceInt solicitacaoReservaService;
    @PostMapping
    public ResponseEntity<SolicitacaoReserva> cadastroReserva(
            @RequestBody ReservaRequestPostDTO reservaDTO) {
        return new ResponseEntity<>(solicitacaoReservaService.criarSolicitacaoReserva(reservaDTO), HttpStatus.OK);
//        return ResponseEntity.status(200).body(new Reserva());
//        return ResponseEntity.ok(solicitacaoReservaService.criarSolicitacaoReserva(reservaDTO));
    }
}
