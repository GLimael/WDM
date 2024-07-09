package net.weg.wdm.wdm.repository;

import net.weg.wdm.wdm.entity.SolicitacaoReserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolicitacaoReservaRepository extends JpaRepository<SolicitacaoReserva, Long> {
}
