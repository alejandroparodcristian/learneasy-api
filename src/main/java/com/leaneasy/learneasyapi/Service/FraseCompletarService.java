package com.leaneasy.learneasyapi.Service;

import com.leaneasy.learneasyapi.Model.FraseCompletar;
import com.leaneasy.learneasyapi.Repository.FraseCompletarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FraseCompletarService {

    @Autowired
    private FraseCompletarRepository fraseRepo;

    public List<FraseCompletar> obtenerFrasesPorLeccionYDificultad(Integer leccionId, String dificultad) {
        return fraseRepo.findByPregunta_Leccion_IdAndDificultad(leccionId, dificultad);
    }
}

