package com.leaneasy.learneasyapi.Service;

import com.leaneasy.learneasyapi.Model.Respuesta;
import com.leaneasy.learneasyapi.Repository.RespuestaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RespuestaService {

    private final RespuestaRepository repo;

    public RespuestaService(RespuestaRepository repo) {
        this.repo = repo;
    }

    public List<Respuesta> listarTodas() {
        return repo.findAll();
    }

    public Respuesta guardar(Respuesta respuesta) {
        return repo.save(respuesta);
    }

    public Respuesta obtenerPorId(int id) {
        return repo.findById(id).orElse(null);
    }

    public void eliminar(int id) {
        repo.deleteById(id);
    }
}
