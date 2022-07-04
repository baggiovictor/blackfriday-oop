package com.baggiovictor.blackfriday.entities;

import com.baggiovictor.blackfriday.entities.enums.SituacaoPedido;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "pedido")
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant momentoPedido;

    private Integer situacaoPedido;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Usuario cliente;

    @OneToMany(mappedBy = "id.pedido")
    private Set<ItemPedido> itensPedido = new HashSet<>();

    @OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL)
    private Pagamento pagamento;

    public Pedido() {}

    public Pedido(Long id, Instant momentoPedido, SituacaoPedido situacaoPedido, Usuario cliente) {
        this.id = id;
        this.momentoPedido = momentoPedido;
        setSituacaoPedido(situacaoPedido);
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMomentoPedido() {
        return momentoPedido;
    }

    public void setMomentoPedido(Instant momentoPedido) {
        this.momentoPedido = momentoPedido;
    }

    public SituacaoPedido getSituacaoPedido() {
        return SituacaoPedido.valueOf(situacaoPedido);
    }

    public void setSituacaoPedido(SituacaoPedido situacaoPedido) {
        if (situacaoPedido != null) {
            this.situacaoPedido = situacaoPedido.getCode();
        }

    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public Set<ItemPedido> getItensPedido() {
        return itensPedido;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return id.equals(pedido.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
