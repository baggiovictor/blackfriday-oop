package com.baggiovictor.blackfriday.resources;

import com.baggiovictor.blackfriday.entities.Categoria;
import com.baggiovictor.blackfriday.entities.Usuario;
import com.baggiovictor.blackfriday.services.CategoriaService;
import com.baggiovictor.blackfriday.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
