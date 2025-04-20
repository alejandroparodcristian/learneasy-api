package com.leaneasy.learneasyapi.Controller;

import com.leaneasy.learneasyapi.Model.Pregunta;
import com.leaneasy.learneasyapi.Service.PreguntaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/preguntas")
public class PreguntaController {

    private final PreguntaService servicio;

    public PreguntaController(PreguntaService servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public List<Pregunta> listar() {
        return servicio.listarTodas();
    }

    @PostMapping
    public Pregunta crear(@RequestBody Pregunta pregunta) {
        return servicio.guardar(pregunta);
    }

    @GetMapping("/{id}")
    public Pregunta obtener(@PathVariable int id) {
        return servicio.obtenerPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        servicio.eliminar(id);
    }
}
