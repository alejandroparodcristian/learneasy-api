package com.leaneasy.learneasyapi.Repository;

import com.leaneasy.learneasyapi.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    //Uso para el login encuentra por id pq es único
    Optional<Usuario> findByEmail(String email);
}
