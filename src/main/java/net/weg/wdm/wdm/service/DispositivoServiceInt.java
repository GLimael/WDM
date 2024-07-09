package net.weg.wdm.wdm.service;

import net.weg.wdm.wdm.entity.Dispositivo;
import net.weg.wdm.wdm.entity.TipoDispositivo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface DispositivoServiceInt {
    Map<TipoDispositivo, List<Dispositivo>> buscarDispositivosPorIdSeparadosPorTipo(List<Long> ids);
}
