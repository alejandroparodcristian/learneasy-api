package com.leaneasy.learneasyapi.Model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ProgresoUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "leccion_id")
    private Leccion leccion;

    @ManyToOne
    @JoinColumn(name = "juego_id")
    private Juego juego;

    private String tipoJuego;

    private String dificultad; // ✅ NUEVO CAMPO

    private int puntos;

    private boolean completado;

    @Column(columnDefinition = "TEXT")
    private String estadoPartida;

    private LocalDateTime fecha;

    @PrePersist
    public void prePersist() {
        this.fecha = LocalDateTime.now();
    }
}
