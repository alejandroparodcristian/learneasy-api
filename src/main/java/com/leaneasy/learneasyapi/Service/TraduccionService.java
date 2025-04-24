package com.leaneasy.learneasyapi.Service;

import com.leaneasy.learneasyapi.Model.Traduccion;
import com.leaneasy.learneasyapi.Repository.TraduccionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TraduccionService {

    private final TraduccionRepository repo;

    public TraduccionService(TraduccionRepository repo) {
        this.repo = repo;
    }

    public List<Traduccion> obtenerPorPregunta(int preguntaId) {
        return repo.findByPreguntaId(preguntaId);
    }

    public List<Traduccion> obtenerPorPreguntaYdificultad(int preguntaId, String dificultad) {
        return repo.findByPreguntaIdAndDificultad(preguntaId, dificultad);
    }

    public Traduccion guardar(Traduccion t) {
        return repo.save(t);
    }

    public void eliminar(int id) {
        repo.deleteById(id);
    }

    public List<Traduccion> listarTodas() {
        return repo.findAll();
    }
}
