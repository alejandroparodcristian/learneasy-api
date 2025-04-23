package com.leaneasy.learneasyapi.Controller;

import com.leaneasy.learneasyapi.Model.Leccion;
import com.leaneasy.learneasyapi.Service.LeccionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lecciones")
public class LeccionController {

    private final LeccionService servicio;

    public LeccionController(LeccionService servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public List<Leccion> listar() {
        return servicio.listarTodas();
    }

    @PostMapping
    public Leccion crear(@RequestBody Leccion leccion) {
        return servicio.guardar(leccion);
    }

    @GetMapping("/{id}")
    public Leccion obtener(@PathVariable int id) {
        return servicio.obtenerPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        servicio.eliminar(id);
    }
    @GetMapping("/por-idioma/{idIdioma}")
    public List<Leccion> obtenerPorIdioma(@PathVariable int idIdioma) {
        return servicio.listarPorIdioma(idIdioma);
    }
}
