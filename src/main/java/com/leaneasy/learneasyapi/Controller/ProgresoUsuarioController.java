package com.leaneasy.learneasyapi.Controller;

import com.leaneasy.learneasyapi.Model.ProgresoUsuario;
import com.leaneasy.learneasyapi.Service.ProgresoUsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/progreso")
public class ProgresoUsuarioController {

    private final ProgresoUsuarioService servicio;

    public ProgresoUsuarioController(ProgresoUsuarioService servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public List<ProgresoUsuario> listar() {
        return servicio.listarTodos();
    }

    @PostMapping
    public ProgresoUsuario crear(@RequestBody ProgresoUsuario progreso) {
        return servicio.guardar(progreso);
    }

    @PutMapping("/{id}")
    public ProgresoUsuario actualizar(@PathVariable int id, @RequestBody ProgresoUsuario actualizado) {
        ProgresoUsuario existente = servicio.obtenerPorId(id);
        if (existente != null) {
            actualizado.setId(id);
            return servicio.guardar(actualizado);
        } else {
            return null;
        }
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
}
