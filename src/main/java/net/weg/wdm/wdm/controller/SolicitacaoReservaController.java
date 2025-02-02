package net.weg.wdm.wdm.controller;

import lombok.AllArgsConstructor;
import net.weg.wdm.wdm.controller.dto.solicitacao.SolicitacaoReservaRequestPostDTO;
import net.weg.wdm.wdm.controller.dto.solicitacao.SolicitacaoReservaResponseDTO;
import net.weg.wdm.wdm.controller.dto.solicitacao.SolicitacaoResponseDTO;
import net.weg.wdm.wdm.entity.SolicitacaoReserva;
import net.weg.wdm.wdm.service.SolicitacaoReservaServiceInt;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/solicitacao")
public class SolicitacaoReservaController {
    private SolicitacaoReservaServiceInt solicitacaoReservaService;
    @PostMapping
    public ResponseEntity<SolicitacaoReserva> cadastroSolicitacao(
            @RequestBody SolicitacaoReservaRequestPostDTO reservaDTO) {
        return new ResponseEntity<>(solicitacaoReservaService.criarSolicitacaoReserva(reservaDTO), HttpStatus.OK);
//        return ResponseEntity.status(200).body(new Reserva());
//        return ResponseEntity.ok(solicitacaoReservaService.criarSolicitacaoReserva(reservaDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SolicitacaoReserva> buscarSolicitacao(@PathVariable Long id) {
        return new ResponseEntity<>(solicitacaoReservaService.buscarSolicitacao(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<SolicitacaoReservaResponseDTO>> buscarTodasSolicitacoes() {
        return new ResponseEntity<>(solicitacaoReservaService.buscarTodasSolicitacoes(), HttpStatus.OK);
    }

    @GetMapping("/page")
    public ResponseEntity<Page<SolicitacaoResponseDTO>> buscarTodasSolicitacoesPage(
            @PageableDefault(sort = "id", direction = Sort.Direction.DESC, size = 15) Pageable pageable) {
        return new ResponseEntity<>(solicitacaoReservaService.buscarTodasSolicitacoesPage(pageable), HttpStatus.OK);
    }
}
