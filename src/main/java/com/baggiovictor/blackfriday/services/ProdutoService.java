package com.baggiovictor.blackfriday.services;

import com.baggiovictor.blackfriday.entities.Produto;
import com.baggiovictor.blackfriday.entities.Usuario;
import com.baggiovictor.blackfriday.repositories.ProdutoRepository;
import com.baggiovictor.blackfriday.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository repository;

    public List<Produto> buscarTodos() {
        return repository.findAll();
    }

    public Produto buscarPorId(Long id) {
        Optional<Produto> produto = repository.findById(id);
        return produto.get();
    }

    public Produto create(Produto produto) {
        return repository.save(produto);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Produto update(Long id, Produto produto) {
        Produto entity = repository.getOne(id);
        atualizarDados(entity, produto);
        return repository.save(entity);
    }

    private void atualizarDados(Produto entity, Produto produto) {
        entity.setNome(produto.getNome());
        entity.setDescricao(produto.getDescricao());
        entity.setPreco(produto.getPreco());
    }

}
