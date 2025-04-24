package com.leaneasy.learneasyapi.Repository;

import com.leaneasy.learneasyapi.Model.Juego;
import com.leaneasy.learneasyapi.Model.LeccionJuego;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LeccionJuegoRepository extends JpaRepository<LeccionJuego, Integer> {

    @Query("SELECT lj.juego FROM LeccionJuego lj WHERE lj.leccion.id = :leccionId")
    List<Juego> findJuegosByLeccionId(int leccionId);
}
