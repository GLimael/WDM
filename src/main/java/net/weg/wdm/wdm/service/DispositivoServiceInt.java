package net.weg.wdm.wdm.service;

import net.weg.wdm.wdm.entity.Dispositivo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DispositivoServiceInt {
    List<Dispositivo> buscarDispositivosPorId(List<Long> ids);
}
