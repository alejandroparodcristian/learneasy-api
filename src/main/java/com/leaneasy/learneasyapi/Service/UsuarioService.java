package com.leaneasy.learneasyapi.Service;

import com.leaneasy.learneasyapi.Model.Usuario;
import com.leaneasy.learneasyapi.Repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository repo;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository repo, PasswordEncoder passwordEncoder) {
        this.repo = repo;
        this.passwordEncoder = passwordEncoder;
    }

    public List<Usuario> listarTodos() {
        return repo.findAll();
    }

    public Usuario guardar(Usuario usuario) {
        if (!usuario.getPassword().startsWith("$2a$")) {
            usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        }

        // Solo asigna fecha si es un usuario nuevo
        if (usuario.getId() == null && usuario.getFechaRegistro() == null) {
            usuario.setFechaRegistro(LocalDate.now());
        }

        return repo.save(usuario);
    }



    //Login busca por id y la contraseña
    public Usuario login(String email, String password) {
        return repo.findByEmail(email).filter(usuario -> passwordEncoder.matches(password, usuario.getPassword())).orElse(null);
    }

    public Usuario actualizarNombre(Integer id, String nuevoNombre) {
        Usuario usuario = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        usuario.setNombre(nuevoNombre);
        return repo.save(usuario);
    }



    public Usuario buscarPorId(Integer id) {
        return repo.findById(id).orElse(null);
    }

    public void eliminarPorId(Integer id) {
        repo.deleteById(id);
    }
}
