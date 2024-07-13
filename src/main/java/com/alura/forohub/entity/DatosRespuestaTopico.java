package com.alura.forohub.entity;

public record DatosRespuestaTopico(
        Long id,
        String titulo,
        String mensaje,
        String fechaCreacion,
        String estadoDelTopico,
        String autor,
        String curso
) {
    public DatosRespuestaTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion().toString(), topico.getEstadoDelTopico(), topico.getAutor().getNombre(), topico.getCurso().getNombre());
    }
}
