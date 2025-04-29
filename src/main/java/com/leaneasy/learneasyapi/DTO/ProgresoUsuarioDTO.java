package com.leaneasy.learneasyapi.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProgresoUsuarioDTO {
    private int usuarioId;
    private int leccionId;
    private int juegoId;
    private boolean completado;
    private int puntos;
    private String dificultad;
    private String tipoJuego;
    private String estadoPartida;
}
