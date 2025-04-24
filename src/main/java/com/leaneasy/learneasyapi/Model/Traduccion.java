package com.leaneasy.learneasyapi.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Traduccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "palabra_es", nullable = false)
    private String palabraEs;

    @Column(name = "palabra_en", nullable = false)
    private String palabraEn;

    @Column(nullable = false)
    private String dificultad;

    @ManyToOne
    @JoinColumn(name = "pregunta_id", nullable = false)
    private Pregunta pregunta;
}
