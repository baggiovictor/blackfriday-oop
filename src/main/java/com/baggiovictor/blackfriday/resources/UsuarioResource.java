package com.baggiovictor.blackfriday.resources;

import com.baggiovictor.blackfriday.entities.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioResource {

    @GetMapping
    public ResponseEntity<Usuario> findAll() {
        Usuario u = new Usuario(1L, "Victor", "victor@gmail.com", "9992393493", "124312");
        return  ResponseEntity.ok().body(u);
    }

}
