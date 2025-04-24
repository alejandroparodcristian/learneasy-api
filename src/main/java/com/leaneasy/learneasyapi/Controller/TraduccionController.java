package com.leaneasy.learneasyapi.Controller;

import com.leaneasy.learneasyapi.Model.Traduccion;
import com.leaneasy.learneasyapi.Service.TraduccionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/traducciones")
public class TraduccionController {

    private final TraduccionService servicio;

    public TraduccionController(TraduccionService servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/pregunta/{id}")
    public List<Traduccion> obtenerPorPregunta(
            @PathVariable int id,
            @RequestParam(required = false) String dificultad) {
        if (dificultad == null) {
            return servicio.obtenerPorPregunta(id);
        } else {
            return servicio.obtenerPorPreguntaYdificultad(id, dificultad);
        }
    }

    @PostMapping
    public Traduccion crear(@RequestBody Traduccion t) {
        return servicio.guardar(t);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        servicio.eliminar(id);
    }

    @GetMapping
    public List<Traduccion> listar() {
        return servicio.listarTodas();
    }
}
