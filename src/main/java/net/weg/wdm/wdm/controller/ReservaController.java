package net.weg.wdm.wdm.controller;

import net.weg.wdm.wdm.controller.dto.reserva.ReservaRequestPostDTO;
import net.weg.wdm.wdm.entity.Reserva;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reserva")
public class ReservaController {
    @PostMapping
    public ResponseEntity<Reserva> cadastroReserva(
            @RequestBody ReservaRequestPostDTO reservaDTO) {
        return new ResponseEntity<>(new Reserva(), HttpStatus.OK);
//        return ResponseEntity.status(200).body(new Reserva());
    }
}
