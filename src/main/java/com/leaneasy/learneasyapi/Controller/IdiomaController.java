package com.leaneasy.learneasyapi.Controller;

import com.leaneasy.learneasyapi.Model.Idioma;
import com.leaneasy.learneasyapi.Service.IdiomaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/idiomas")
public class IdiomaController {

    private final IdiomaService servicio;

    public IdiomaController(IdiomaService servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public List<Idioma> listar() {
        return servicio.listarTodos();
    }

    @PostMapping
    public Idioma crear(@RequestBody Idioma idioma) {
        return servicio.guardar(idioma);
    }

    @GetMapping("/{id}")
    public Idioma obtener(@PathVariable int id) {
        return servicio.obtenerPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        servicio.eliminar(id);
    }
}
