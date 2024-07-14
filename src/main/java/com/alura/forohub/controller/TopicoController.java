package com.alura.forohub.controller;

import com.alura.forohub.entity.*;
import com.alura.forohub.service.TopicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @PostMapping
    public ResponseEntity<DatosRespuestaTopico> registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico,
                                                                UriComponentsBuilder uriComponentsBuilder) {
        Topico t1 = topicoService.guardarTopico(datosRegistroTopico);
        DatosRespuestaTopico datosRespuestaTopico = new DatosRespuestaTopico(t1);
        //url donde encontrar la info de ese topico
        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(t1.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaTopico);
    }

    @GetMapping
    public ResponseEntity<List<DatosListadoTopico>> listadoTopicos() {
        return ResponseEntity.ok(topicoService.listarTopicos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaTopico> retornaTopicoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(topicoService.encuentraTopicoPorId(id));
    }

    @PutMapping
    public ResponseEntity actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico) {
        Topico t1 = topicoService.actualizarTopicoPorId(datosActualizarTopico);
        return ResponseEntity.ok(new DatosRespuestaTopico(t1));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminarTopico (@PathVariable Long id) {
        topicoService.eliminarTopicoPorId(id);
        return ResponseEntity.noContent().build();
    }

}
