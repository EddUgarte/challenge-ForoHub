package com.alura.forohub.controller;

import com.alura.forohub.entity.DatosListadoTopico;
import com.alura.forohub.entity.DatosRegistroTopico;
import com.alura.forohub.entity.DatosRespuestaTopico;
import com.alura.forohub.service.TopicoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @PostMapping
    public void registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico) {
        topicoService.guardarTopico(datosRegistroTopico);
    }

    @GetMapping
    public List<DatosListadoTopico> listadoTopicos() {
        return topicoService.listarTopicos();
    }

    @GetMapping("/{id}")
    public DatosRespuestaTopico retornaTopicoPorId(@PathVariable Long id) {
        return topicoService.encuentraTopicoPorId(id);
    }


}
