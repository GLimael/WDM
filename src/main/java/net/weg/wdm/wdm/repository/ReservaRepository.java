package net.weg.wdm.wdm.repository;

import net.weg.wdm.wdm.entity.Ambiente;
import net.weg.wdm.wdm.entity.Reserva;
import net.weg.wdm.wdm.entity.StatusReserva;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Ambiente, Long> {

    Long countByTurma_Id(Long idTurma);
    Page<Reserva> findAllByTurma_IdOrderByDiaDesc(Long idTurma);
    Page<Reserva> findAllByTurma_IdAndStatusOrderByDiaDesc(Long idTurma, StatusReserva statusReserva);
    Page<Reserva> findAllByTurma_IdAOrStatusOrderByDiaDesc(Long idTurma, StatusReserva statusReserva);

}
