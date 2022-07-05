package com.baggiovictor.blackfriday.resources;

import com.baggiovictor.blackfriday.entities.Pedido;
import com.baggiovictor.blackfriday.entities.Produto;
import com.baggiovictor.blackfriday.entities.Usuario;
import com.baggiovictor.blackfriday.services.PedidoService;
import com.baggiovictor.blackfriday.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PostMapping(value = "/criarPedido")
    public ResponseEntity<Pedido> create(@RequestBody Pedido pedido) {
        pedido = service.create(pedido);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pedido.getId()).toUri();
        return ResponseEntity.created(uri).body(pedido);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
