package com.baggiovictor.blackfriday.services;

import com.baggiovictor.blackfriday.entities.Usuario;
import com.baggiovictor.blackfriday.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;

    public List<Usuario> buscarTodos() {
        return repository.findAll();
    }

    public Usuario buscarPorId(Long id) {
        Optional<Usuario> usuario = repository.findById(id);
        return usuario.get();
    }

}
