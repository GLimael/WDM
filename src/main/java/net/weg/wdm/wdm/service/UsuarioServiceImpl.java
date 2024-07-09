package net.weg.wdm.wdm.service;

import lombok.AllArgsConstructor;
import net.weg.wdm.wdm.entity.Usuario;
import net.weg.wdm.wdm.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsuarioServiceImpl implements UsuarioServiceInt{
    private final UsuarioRepository usuarioRepository;
    @Override
    public Usuario buscarUsuarioPorId(Long id) {
        return usuarioRepository.findById(id).get();
    }
}
