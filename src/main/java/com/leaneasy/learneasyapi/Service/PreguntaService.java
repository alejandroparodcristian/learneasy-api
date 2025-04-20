package com.leaneasy.learneasyapi.Service;

import com.leaneasy.learneasyapi.Model.Pregunta;
import com.leaneasy.learneasyapi.Repository.PreguntaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PreguntaService {

    private final PreguntaRepository repo;

    public PreguntaService(PreguntaRepository repo) {
        this.repo = repo;
    }

    public List<Pregunta> listarTodas() {
        return repo.findAll();
    }

    public Pregunta guardar(Pregunta pregunta) {
        return repo.save(pregunta);
    }

    public Pregunta obtenerPorId(int id) {
        return repo.findById(id).orElse(null);
    }

    public void eliminar(int id) {
        repo.deleteById(id);
    }
}
