package com.alura.forohub.entity;

import jakarta.validation.constraints.NotBlank;

public record DatosRegistroTopico(
    @NotBlank(message = "Debe indicar id de Usuario")
    String idUsuario,
    @NotBlank(message = "Debe indicar un mensaje")
    String mensaje,
    @NotBlank(message = "Debe indicar nombre del curso")
    String nombreCurso,
    @NotBlank(message = "Debe indicar Titulo del topico")
    String titulo
) {
}
