package com.baggiovictor.blackfriday.resources;

import com.baggiovictor.blackfriday.entities.Produto;
import com.baggiovictor.blackfriday.entities.Usuario;
import com.baggiovictor.blackfriday.services.ProdutoService;
import com.baggiovictor.blackfriday.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoResource {
    @Autowired
    private ProdutoService service;

    @GetMapping
    public ResponseEntity<List<Produto>> buscarTodos() {
        List<Produto> listaProduto = service.buscarTodos();
        return  ResponseEntity.ok().body(listaProduto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable Long id) {
        Produto produto = service.buscarPorId(id);
        return ResponseEntity.ok().body(produto);
    }

    @PostMapping(value = "/criarProduto")
    public ResponseEntity<Produto> create(@RequestBody Produto produto) {
        produto = service.create(produto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(produto.getId()).toUri();
        return ResponseEntity.created(uri).body(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Produto> atualizar(@PathVariable Long id, @RequestBody Produto produto) {
        produto = service.update(id, produto);
        return ResponseEntity.ok().body(produto);
    }

}
