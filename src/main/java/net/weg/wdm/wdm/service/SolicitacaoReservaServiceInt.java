package net.weg.wdm.wdm.service;

import net.weg.wdm.wdm.controller.dto.solicitacao.SolicitacaoReservaRequestPostDTO;
import net.weg.wdm.wdm.controller.dto.solicitacao.SolicitacaoReservaResponseDTO;
import net.weg.wdm.wdm.controller.dto.solicitacao.SolicitacaoResponseDTO;
import net.weg.wdm.wdm.entity.SolicitacaoReserva;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SolicitacaoReservaServiceInt {
    SolicitacaoReserva criarSolicitacaoReserva(SolicitacaoReservaRequestPostDTO requestDTO);

    SolicitacaoReserva buscarSolicitacao(Long id);

    List<SolicitacaoReservaResponseDTO> buscarTodasSolicitacoes();

    Page<SolicitacaoResponseDTO> buscarTodasSolicitacoesPage(Pageable pageable);
}
