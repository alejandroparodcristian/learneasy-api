package com.leaneasy.learneasyapi.Controller;

import com.leaneasy.learneasyapi.Model.Respuesta;
import com.leaneasy.learneasyapi.Service.RespuestaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/respuestas")
public class RespuestaController {

    private final RespuestaService servicio;

    public RespuestaController(RespuestaService servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public List<Respuesta> listar() {
        return servicio.listarTodas();
    }

    @PostMapping
    public Respuesta crear(@RequestBody Respuesta respuesta) {
        return servicio.guardar(respuesta);
    }

    @GetMapping("/{id}")
    public Respuesta obtener(@PathVariable int id) {
        return servicio.obtenerPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        servicio.eliminar(id);
    }
}
