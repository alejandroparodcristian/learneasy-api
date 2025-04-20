package com.leaneasy.learneasyapi.Service;

import com.leaneasy.learneasyapi.Model.ProgresoUsuario;
import com.leaneasy.learneasyapi.Repository.ProgresoUsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgresoUsuarioService {

    private final ProgresoUsuarioRepository repo;

    public ProgresoUsuarioService(ProgresoUsuarioRepository repo) {
        this.repo = repo;
    }

    public List<ProgresoUsuario> listarTodos() {
        return repo.findAll();
    }

    public ProgresoUsuario guardar(ProgresoUsuario progreso) {
        return repo.save(progreso);
    }

    public ProgresoUsuario obtenerPorId(int id) {
        return repo.findById(id).orElse(null);
    }

    public void eliminar(int id) {
        repo.deleteById(id);
    }
}
