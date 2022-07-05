package com.baggiovictor.blackfriday.services;

import com.baggiovictor.blackfriday.entities.Pedido;
import com.baggiovictor.blackfriday.entities.Usuario;
import com.baggiovictor.blackfriday.repositories.PedidoRepository;
import com.baggiovictor.blackfriday.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository repository;

    public List<Pedido> buscarTodos() {
        return repository.findAll();
    }

    public Pedido buscarPorId(Long id) {
        Optional<Pedido> pedido = repository.findById(id);
        return pedido.get();
    }

    public Pedido create(Pedido pedido) { return repository.save(pedido);}

    public void delete(Long id) {
        repository.deleteById(id);
    }

}
