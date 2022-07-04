package com.baggiovictor.blackfriday.config;

import com.baggiovictor.blackfriday.entities.*;
import com.baggiovictor.blackfriday.entities.enums.SituacaoPedido;
import com.baggiovictor.blackfriday.repositories.*;
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

    @Autowired
    ItemPedidoRepository itemPedidoRepository;

    @Override
    public void run(String... args) throws Exception {

        Categoria cat1 = new Categoria(null, "Dispositivos Móveis");
        Categoria cat2 = new Categoria(null, "Livros");
        Categoria cat3 = new Categoria(null, "Roupas");

        categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

        Usuario usuario1 = new Usuario(null, "Victor Baggio", "victorbaggio@gmail.com", "999086753", "132456");
        Usuario usuario2 = new Usuario(null, "Marcos Baggio", "marcosbaggio@gmail.com", "999795955", "444456");

        Pedido pedido1 = new Pedido(null, Instant.parse("2022-06-20T19:53:07Z"), SituacaoPedido.PAGO,usuario1);
        Pedido pedido2 = new Pedido(null, Instant.parse("2022-06-21T03:42:10Z"), SituacaoPedido.ENTREGUE, usuario2);
        Pedido pedido3 = new Pedido(null, Instant.parse("2022-06-22T15:21:22Z"),SituacaoPedido.ENVIADO, usuario1);

        Produto produto1 = new Produto(null, "TV Samsung", "teste tv", 1299.95, null);
        Produto produto2 = new Produto(null, "TV LG", "tv lg", 1699.95, null);
        Produto produto3 = new Produto(null, "Camisa São Paulo", "Camisa adidas spfc", 299.95, null);

        produtoRepository.saveAll(Arrays.asList(produto1, produto2, produto3));

        produto1.getCategorias().add(cat1);
        produto2.getCategorias().add(cat1);
        produto3.getCategorias().add(cat3);

        produtoRepository.saveAll(Arrays.asList(produto1, produto2, produto3));

        usuarioRepository.saveAll(Arrays.asList(usuario1, usuario2));
        pedidoRepository.saveAll(Arrays.asList(pedido1, pedido2, pedido3));

        ItemPedido itemPedido1 = new ItemPedido(pedido1, produto1, 2, produto1.getPreco());
        ItemPedido itemPedido2 = new ItemPedido(pedido2, produto2, 5, produto2.getPreco());

        itemPedidoRepository.saveAll(Arrays.asList(itemPedido1, itemPedido2));

        Pagamento pagamento1 = new Pagamento(null, Instant.parse("2022-06-20T21:53:07Z"), pedido1);
        pedido1.setPagamento(pagamento1);

        pedidoRepository.saveAll(Arrays.asList(pedido1));


    }
}
