package com.baggiovictor.blackfriday.config;

import com.baggiovictor.blackfriday.entities.Categoria;
import com.baggiovictor.blackfriday.entities.Pedido;
import com.baggiovictor.blackfriday.entities.Produto;
import com.baggiovictor.blackfriday.entities.Usuario;
import com.baggiovictor.blackfriday.entities.enums.SituacaoPedido;
import com.baggiovictor.blackfriday.repositories.CategoriaRepository;
import com.baggiovictor.blackfriday.repositories.PedidoRepository;
import com.baggiovictor.blackfriday.repositories.ProdutoRepository;
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

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public void run(String... args) throws Exception {

        Categoria cat1 = new Categoria(null, "Dispositivos Móveis");
        Categoria cat2 = new Categoria(null, "Livros");
        Categoria cat3 = new Categoria(null, "Roupas");

        categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

        Usuario u1 = new Usuario(null, "Victor Baggio", "victorbaggio@gmail.com", "999086753", "132456");
        Usuario u2 = new Usuario(null, "Marcos Baggio", "marcosbaggio@gmail.com", "999795955", "444456");

        Pedido o1 = new Pedido(null, Instant.parse("2022-06-20T19:53:07Z"), SituacaoPedido.AGUARDANDO_PAGAMENTO,u1 );
        Pedido o2 = new Pedido(null, Instant.parse("2022-06-21T03:42:10Z"), SituacaoPedido.ENTREGUE, u2);
        Pedido o3 = new Pedido(null, Instant.parse("2022-06-22T15:21:22Z"),SituacaoPedido.ENVIADO, u1);

        Produto produto1 = new Produto(null, "TV Samsung", "teste tv", 1299.95, null);
        Produto produto2 = new Produto(null, "TV LG", "tv lg", 1699.95, null);
        Produto produto3 = new Produto(null, "Camisa São Paulo", "Camisa adidas spfc", 299.95, null);


        produtoRepository.saveAll(Arrays.asList(produto1, produto2, produto3));

        produto1.getCategorias().add(cat1);
        produto2.getCategorias().add(cat1);
        produto3.getCategorias().add(cat3);

        produtoRepository.saveAll(Arrays.asList(produto1, produto2, produto3));

        usuarioRepository.saveAll(Arrays.asList(u1, u2));
        pedidoRepository.saveAll(Arrays.asList(o1, o2, o3));


    }
}
