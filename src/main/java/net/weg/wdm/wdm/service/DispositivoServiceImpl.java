package net.weg.wdm.wdm.service;

import lombok.AllArgsConstructor;
import net.weg.wdm.wdm.entity.Dispositivo;
import net.weg.wdm.wdm.entity.DispositivoReservado;
import net.weg.wdm.wdm.repository.DispositivoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@Service
public class DispositivoServiceImpl implements DispositivoServiceInt{

    private DispositivoRepository dispositivoRepository;

    @Override
    public List<Dispositivo> buscarDispositivosPorId(List<Long> ids) {
        return dispositivoRepository.findAllById(ids);
    }
}
