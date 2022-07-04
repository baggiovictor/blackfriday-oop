package com.baggiovictor.blackfriday.resources;

import com.baggiovictor.blackfriday.entities.Categoria;
import com.baggiovictor.blackfriday.entities.Usuario;
import com.baggiovictor.blackfriday.services.CategoriaService;
import com.baggiovictor.blackfriday.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.Repository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/categoria")
public class CategoriaResource {
    @Autowired
    private CategoriaService service;

    @GetMapping
    public ResponseEntity<List<Categoria>> buscarTodos() {
        List<Categoria> listaCategoria = service.buscarTodos();
        return  ResponseEntity.ok().body(listaCategoria);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Categoria> buscarPorId(@PathVariable Long id) {
        Categoria categoria = service.buscarPorId(id);
        return ResponseEntity.ok().body(categoria);
    }

    @PostMapping(value = "/criarCategoria")
    public ResponseEntity<Categoria> create(@RequestBody Categoria categoria) {
        categoria = service.create(categoria);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(categoria.getId()).toUri();
        return ResponseEntity.created(uri).body(categoria);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Categoria> atualizar(@PathVariable Long id, @RequestBody Categoria categoria) {
        categoria = service.update(id, categoria);
        return ResponseEntity.ok().body(categoria);
    }


}
