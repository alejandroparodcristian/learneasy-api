package com.leaneasy.learneasyapi.Repository;

import com.leaneasy.learneasyapi.Model.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PreguntaRepository extends JpaRepository<Pregunta, Integer> {
    @Query("SELECT p FROM Pregunta p WHERE p.leccion.id = :leccionId AND p.tipo = :tipo")
    Optional<Pregunta> findByLeccionIdAndTipo(@Param("leccionId") int leccionId, @Param("tipo") String tipo);
}
