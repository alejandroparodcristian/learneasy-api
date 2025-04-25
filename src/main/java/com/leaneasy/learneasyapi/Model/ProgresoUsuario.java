package com.leaneasy.learneasyapi.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class ProgresoUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "leccion_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Leccion leccion;

    @ManyToOne
    @JoinColumn(name = "juego_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Juego juego;

    private boolean completado;

    private int puntos;

    private String tipoJuego;

    @Column(columnDefinition = "TEXT")
    private String estadoPartida;

    private LocalDateTime fecha;

    @PrePersist
    public void prePersist() {
        if (fecha == null) {
            fecha = LocalDateTime.now();
        }
    }
}
