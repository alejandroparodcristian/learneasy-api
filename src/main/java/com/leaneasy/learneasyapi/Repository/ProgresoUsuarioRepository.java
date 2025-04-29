package com.leaneasy.learneasyapi.Repository;

import com.leaneasy.learneasyapi.Model.ProgresoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProgresoUsuarioRepository extends JpaRepository<ProgresoUsuario, Integer> {
    List<ProgresoUsuario> findByUsuarioIdAndLeccionIdAndJuegoId(int usuarioId, int leccionId, int juegoId);

    ProgresoUsuario findTopByUsuarioIdAndLeccionIdAndJuegoIdOrderByFechaDesc(int usuarioId, int leccionId, int juegoId);

    @Query("SELECT p FROM ProgresoUsuario p WHERE p.usuario.id = :usuarioId AND p.leccion.id = :leccionId AND p.juego.id = :juegoId AND p.dificultad = :dificultad")
    ProgresoUsuario findByUsuarioIdAndLeccionIdAndJuegoIdAndDificultad(@Param("usuarioId") int usuarioId,
                                                                       @Param("leccionId") int leccionId,
                                                                       @Param("juegoId") int juegoId,
                                                                       @Param("dificultad") String dificultad);


}
