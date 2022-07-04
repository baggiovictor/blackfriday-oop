package com.baggiovictor.blackfriday.services;

import com.baggiovictor.blackfriday.entities.Usuario;
import com.baggiovictor.blackfriday.repositories.UsuarioRepository;
import com.baggiovictor.blackfriday.services.exceptions.ResourceNotFoundException;
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
        return usuario.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Usuario create(Usuario usuario) {
        return repository.save(usuario);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Usuario update(Long id, Usuario usuario) {
        Usuario entity = repository.getOne(id);
        atualizarDados(entity, usuario);
        return repository.save(entity);
    }

    private void atualizarDados(Usuario entity, Usuario usuario) {
        entity.setNome(usuario.getNome());
        entity.setEmail(usuario.getEmail());
        entity.setTelefone(usuario.getTelefone());
    }

}
