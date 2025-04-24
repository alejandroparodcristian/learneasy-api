package com.leaneasy.learneasyapi.Service;

import com.leaneasy.learneasyapi.Model.Juego;
import com.leaneasy.learneasyapi.Repository.LeccionJuegoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JuegoService {

    private final LeccionJuegoRepository leccionJuegoRepository;

    public JuegoService(LeccionJuegoRepository leccionJuegoRepository) {
        this.leccionJuegoRepository = leccionJuegoRepository;
    }

    public List<Juego> obtenerJuegosPorLeccion(int leccionId) {
        return leccionJuegoRepository.findJuegosByLeccionId(leccionId);
    }
}
