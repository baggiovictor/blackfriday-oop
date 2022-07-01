package com.baggiovictor.blackfriday.resources;

import com.baggiovictor.blackfriday.entities.Usuario;
import com.baggiovictor.blackfriday.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioResource {
    @Autowired
    private UsuarioService service;

    @GetMapping
    public ResponseEntity<List<Usuario>> buscarTodos() {
        List<Usuario> listaUsuario = service.buscarTodos();
        return  ResponseEntity.ok().body(listaUsuario);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable Long id) {
        Usuario usuario = service.buscarPorId(id);
        return ResponseEntity.ok().body(usuario);
    }

}
