package com.leaneasy.learneasyapi.Repository;

import com.leaneasy.learneasyapi.Model.Idioma;
import com.leaneasy.learneasyapi.Model.Leccion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LeccionRepository extends JpaRepository<Leccion, Integer> {
    List<Leccion> findByIdioma(Idioma idioma);
}
