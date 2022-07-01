package com.baggiovictor.blackfriday.repositories;

import com.baggiovictor.blackfriday.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
