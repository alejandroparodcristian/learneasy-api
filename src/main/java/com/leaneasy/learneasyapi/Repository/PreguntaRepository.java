package com.leaneasy.learneasyapi.Repository;

import com.leaneasy.learneasyapi.Model.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PreguntaRepository extends JpaRepository<Pregunta, Integer> {
}
