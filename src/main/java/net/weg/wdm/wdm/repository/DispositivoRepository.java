package net.weg.wdm.wdm.repository;

import net.weg.wdm.wdm.entity.Dispositivo;
import net.weg.wdm.wdm.entity.GrupoDispositivo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DispositivoRepository extends JpaRepository<Dispositivo, Long> {
}
