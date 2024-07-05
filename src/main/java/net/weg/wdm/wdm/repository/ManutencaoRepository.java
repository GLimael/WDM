package net.weg.wdm.wdm.repository;

import net.weg.wdm.wdm.entity.Ambiente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManutencaoRepository extends JpaRepository<Ambiente, Long> {
}
