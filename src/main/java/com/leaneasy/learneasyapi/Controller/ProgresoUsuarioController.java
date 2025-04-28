package com.leaneasy.learneasyapi.Controller;

import com.leaneasy.learneasyapi.DTO.ProgresoUsuarioDTO;
import com.leaneasy.learneasyapi.Model.Juego;
import com.leaneasy.learneasyapi.Model.Leccion;
import com.leaneasy.learneasyapi.Model.ProgresoUsuario;
import com.leaneasy.learneasyapi.Model.Usuario;
import com.leaneasy.learneasyapi.Repository.JuegoRepository;
import com.leaneasy.learneasyapi.Repository.LeccionRepository;
import com.leaneasy.learneasyapi.Repository.ProgresoUsuarioRepository;
import com.leaneasy.learneasyapi.Repository.UsuarioRepository;
import com.leaneasy.learneasyapi.Service.ProgresoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/progreso")
public class ProgresoUsuarioController {

    private final ProgresoUsuarioService servicio;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private LeccionRepository leccionRepository;

    @Autowired
    private JuegoRepository juegoRepository;

    @Autowired
    private ProgresoUsuarioRepository progresoUsuarioRepository;

    public ProgresoUsuarioController(ProgresoUsuarioService servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public List<ProgresoUsuario> listar() {
        return servicio.listarTodos();
    }

    @GetMapping("/{id}")
    public ProgresoUsuario obtener(@PathVariable int id) {
        return servicio.obtenerPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        servicio.eliminar(id);
    }

    @GetMapping("/buscar")
    public List<ProgresoUsuario> buscarPorUsuarioLeccionYJuego(
            @RequestParam int usuarioId,
            @RequestParam int leccionId,
            @RequestParam int juegoId) {
        return servicio.buscarPorUsuarioLeccionYJuego(usuarioId, leccionId, juegoId);
    }

    @PostMapping
    public ResponseEntity<ProgresoUsuario> guardarProgreso(@RequestBody ProgresoUsuarioDTO dto) {
        Optional<Usuario> usuario = usuarioRepository.findById(dto.getUsuarioId());
        Optional<Leccion> leccion = leccionRepository.findById(dto.getLeccionId());
        Optional<Juego> juego = juegoRepository.findById(dto.getJuegoId());

        if (usuario.isEmpty() || leccion.isEmpty() || juego.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        ProgresoUsuario progreso = new ProgresoUsuario();
        progreso.setUsuario(usuario.get());
        progreso.setLeccion(leccion.get());
        progreso.setJuego(juego.get());
        progreso.setCompletado(dto.isCompletado());
        progreso.setPuntos(dto.getPuntos());
        progreso.setTipoJuego(dto.getTipoJuego());
        progreso.setEstadoPartida(dto.getEstadoPartida());

        ProgresoUsuario guardado = progresoUsuarioRepository.save(progreso);

        return ResponseEntity.ok(guardado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProgresoUsuario> actualizar(@PathVariable int id, @RequestBody ProgresoUsuarioDTO dto) {
        Optional<ProgresoUsuario> existenteOpt = progresoUsuarioRepository.findById(id);
        if (existenteOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        ProgresoUsuario existente = existenteOpt.get();

        Optional<Usuario> usuario = usuarioRepository.findById(dto.getUsuarioId());
        Optional<Leccion> leccion = leccionRepository.findById(dto.getLeccionId());
        Optional<Juego> juego = juegoRepository.findById(dto.getJuegoId());

        if (usuario.isEmpty() || leccion.isEmpty() || juego.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        existente.setUsuario(usuario.get());
        existente.setLeccion(leccion.get());
        existente.setJuego(juego.get());
        existente.setCompletado(dto.isCompletado());
        existente.setPuntos(dto.getPuntos());
        existente.setTipoJuego(dto.getTipoJuego());
        existente.setEstadoPartida(dto.getEstadoPartida());

        ProgresoUsuario actualizado = progresoUsuarioRepository.save(existente);

        return ResponseEntity.ok(actualizado);
    }
}
