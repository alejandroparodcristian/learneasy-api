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

    @GetMapping("/{id}")
    public ProgresoUsuario obtener(@PathVariable int id) {
        return servicio.obtenerPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        servicio.eliminar(id);
    }
}
