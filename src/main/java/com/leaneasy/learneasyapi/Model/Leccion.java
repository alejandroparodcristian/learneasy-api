package com.leaneasy.learneasyapi.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Getter
@Setter
public class Leccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String titulo;

    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "idioma_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Idioma idioma;

    private Integer nivel;
}
