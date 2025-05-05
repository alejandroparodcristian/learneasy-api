package com.leaneasy.learneasyapi.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;


@Data
@AllArgsConstructor
public class UsuarioDTO {
    private Integer id;
    private String nombre;
    private String email;
    private LocalDate fechaRegistro;
}
