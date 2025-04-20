package com.leaneasy.learneasyapi.Service;

import com.leaneasy.learneasyapi.Model.Idioma;
import com.leaneasy.learneasyapi.Repository.IdiomaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IdiomaService {

    private final IdiomaRepository repo;

    public IdiomaService(IdiomaRepository repo) {
        this.repo = repo;
    }

    public List<Idioma> listarTodos() {
        return repo.findAll();
    }

    public Idioma guardar(Idioma idioma) {
        return repo.save(idioma);
    }

    public Idioma obtenerPorId(int id) {
        return repo.findById(id).orElse(null);
    }

    public void eliminar(int id) {
        repo.deleteById(id);
    }
}
