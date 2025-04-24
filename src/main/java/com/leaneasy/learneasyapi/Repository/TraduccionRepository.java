package com.leaneasy.learneasyapi.Repository;

import com.leaneasy.learneasyapi.Model.Traduccion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TraduccionRepository extends JpaRepository<Traduccion, Integer> {
    List<Traduccion> findByPreguntaId(int preguntaId);
    List<Traduccion> findByPreguntaIdAndDificultad(int preguntaId, String dificultad);
}
