package com.baggiovictor.blackfriday.config;

import com.baggiovictor.blackfriday.entities.Pedido;
import com.baggiovictor.blackfriday.entities.Usuario;
import com.baggiovictor.blackfriday.repositories.PedidoRepository;
import com.baggiovictor.blackfriday.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public void run(String... args) throws Exception {
        Usuario u1 = new Usuario(null, "Victor Baggio", "victorbaggio@gmail.com", "999086753", "132456");
        Usuario u2 = new Usuario(null, "Marcos Baggio", "marcosbaggio@gmail.com", "999795955", "444456");

        Pedido o1 = new Pedido(null, Instant.parse("2022-06-20T19:53:07Z"), u1);
        Pedido o2 = new Pedido(null, Instant.parse("2022-06-21T03:42:10Z"), u2);
        Pedido o3 = new Pedido(null, Instant.parse("2022-06-22T15:21:22Z"), u1);

        usuarioRepository.saveAll(Arrays.asList(u1, u2));
        pedidoRepository.saveAll(Arrays.asList(o1, o2, o3));
    }
}
