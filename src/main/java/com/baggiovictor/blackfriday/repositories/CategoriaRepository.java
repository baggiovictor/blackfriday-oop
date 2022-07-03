package com.baggiovictor.blackfriday.repositories;

import com.baggiovictor.blackfriday.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
