package com.leaneasy.learneasyapi.Controller;

import com.leaneasy.learneasyapi.Model.FraseCompletar;
import com.leaneasy.learneasyapi.Service.FraseCompletarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/frases")
public class FraseCompletarController {

    @Autowired
    private FraseCompletarService fraseService;

    @GetMapping("/leccion/{leccionId}/dificultad/{dificultad}")
    public ResponseEntity<List<FraseCompletar>> getFrases(
            @PathVariable Integer leccionId,
            @PathVariable String dificultad) {

        List<FraseCompletar> frases = fraseService.obtenerFrasesPorLeccionYDificultad(leccionId, dificultad);

        if (frases.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(frases);
    }
}


