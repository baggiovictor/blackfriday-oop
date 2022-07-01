package com.baggiovictor.blackfriday.repositories;

import com.baggiovictor.blackfriday.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
