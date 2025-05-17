package com.leaneasy.learneasyapi.Repository;

import com.leaneasy.learneasyapi.Model.FraseCompletar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FraseCompletarRepository extends JpaRepository<FraseCompletar, Long> {
    List<FraseCompletar> findByPregunta_Leccion_IdAndDificultad(Integer leccionId, String dificultad);
}

