package com.leaneasy.learneasyapi.Service;

import com.leaneasy.learneasyapi.Model.Idioma;
import com.leaneasy.learneasyapi.Model.Leccion;
import com.leaneasy.learneasyapi.Repository.IdiomaRepository;
import com.leaneasy.learneasyapi.Repository.LeccionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeccionService {

    private final LeccionRepository repo;
    private final IdiomaRepository idiomaRepo;

    public LeccionService(LeccionRepository repo, IdiomaRepository idiomaRepo) {
        this.repo = repo;
        this.idiomaRepo = idiomaRepo;
    }

    public List<Leccion> listarTodas() {
        return repo.findAll();
    }

    public Leccion guardar(Leccion leccion) {
        // Obtener el idioma de la BD usando su ID
        if (leccion.getIdioma() != null && leccion.getIdioma().getId() != 0) {
            Idioma idiomaPersistido = idiomaRepo.findById(leccion.getIdioma().getId()).orElseThrow(() -> new IllegalArgumentException("Idioma no encontrado"));
            leccion.setIdioma(idiomaPersistido);
        }
        return repo.save(leccion);
    }

    public Leccion obtenerPorId(int id) {
        return repo.findById(id).orElse(null);
    }

    public void eliminar(int id) {
        repo.deleteById(id);
    }
    public List<Leccion> listarPorIdioma(int idIdioma) {
        Idioma idioma = idiomaRepo.findById(idIdioma)
                .orElseThrow(() -> new IllegalArgumentException("Idioma no encontrado"));
        return repo.findByIdioma(idioma);
    }
}
