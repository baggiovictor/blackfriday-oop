package com.baggiovictor.blackfriday.services;

import com.baggiovictor.blackfriday.entities.Categoria;
import com.baggiovictor.blackfriday.entities.Usuario;
import com.baggiovictor.blackfriday.repositories.CategoriaRepository;
import com.baggiovictor.blackfriday.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository repository;

    public List<Categoria> buscarTodos() {
        return repository.findAll();
    }

    public Categoria buscarPorId(Long id) {
        Optional<Categoria> categoria = repository.findById(id);
        return categoria.get();
    }

    public Categoria create(Categoria categoria) {
        return repository.save(categoria);
    }

    public void delete(Long id) {repository.deleteById(id);}

    public Categoria update(Long id, Categoria categoria) {
        Categoria entity = repository.getOne(id);
        atualizarDados(entity, categoria);
        return repository.save(entity);
    }

    private void atualizarDados(Categoria entity, Categoria categoria) {
        entity.setNome(categoria.getNome());
    }

}
