package com.baggiovictor.blackfriday.repositories;

import com.baggiovictor.blackfriday.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
