package com.leaneasy.learneasyapi.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class UsuarioDTO {
    private Integer id;
    private String nombre;
    private String email;
    private LocalDateTime fechaRegistro;
}
