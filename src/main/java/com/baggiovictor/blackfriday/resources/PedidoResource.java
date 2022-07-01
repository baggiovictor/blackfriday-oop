package com.baggiovictor.blackfriday.resources;

import com.baggiovictor.blackfriday.entities.Pedido;
import com.baggiovictor.blackfriday.entities.Usuario;
import com.baggiovictor.blackfriday.services.PedidoService;
import com.baggiovictor.blackfriday.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {
    @Autowired
    private PedidoService service;

    @GetMapping
    public ResponseEntity<List<Pedido>> buscarTodos() {
        List<Pedido> listaUsuario = service.buscarTodos();
        return  ResponseEntity.ok().body(listaUsuario);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Pedido> buscarPorId(@PathVariable Long id) {
        Pedido pedido = service.buscarPorId(id);
        return ResponseEntity.ok().body(pedido);
    }

}
