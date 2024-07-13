package com.alura.forohub.entity;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(@NotNull Long id, String titulo, String mensaje) {
}
