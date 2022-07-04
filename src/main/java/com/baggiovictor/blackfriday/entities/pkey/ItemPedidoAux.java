package com.baggiovictor.blackfriday.entities.pkey;

import com.baggiovictor.blackfriday.entities.Pedido;
import com.baggiovictor.blackfriday.entities.Produto;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ItemPedidoAux implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;
    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Produto produto;

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemPedidoAux that = (ItemPedidoAux) o;
        return pedido.equals(that.pedido) && produto.equals(that.produto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pedido, produto);
    }
}
