package com.leaneasy.learneasyapi.Repository;

import com.leaneasy.learneasyapi.Model.ProgresoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProgresoUsuarioRepository extends JpaRepository<ProgresoUsuario, Integer> {
    List<ProgresoUsuario> findByUsuarioIdAndLeccionIdAndJuegoId(int usuarioId, int leccionId, int juegoId);

    ProgresoUsuario findTopByUsuarioIdAndLeccionIdAndJuegoIdOrderByFechaDesc(int usuarioId, int leccionId, int juegoId);
}
