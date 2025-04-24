package com.leaneasy.learneasyapi.Controller;

import com.leaneasy.learneasyapi.Model.Juego;
import com.leaneasy.learneasyapi.Service.JuegoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/juegos")
public class JuegoController {

    private final JuegoService juegoService;

    public JuegoController(JuegoService juegoService) {
        this.juegoService = juegoService;
    }

    @GetMapping("/por-leccion/{id}")
    public List<Juego> obtenerPorLeccion(@PathVariable int id) {
        return juegoService.obtenerJuegosPorLeccion(id);
    }
}
