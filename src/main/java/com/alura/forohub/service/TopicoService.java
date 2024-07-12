package com.alura.forohub.service;

import com.alura.forohub.entity.Autor;
import com.alura.forohub.entity.Curso;
import com.alura.forohub.entity.DatosRegistroTopico;
import com.alura.forohub.entity.Topico;
import com.alura.forohub.repository.AutorRepository;
import com.alura.forohub.repository.CursoRepository;
import com.alura.forohub.repository.TopicoRepository;
import jakarta.transaction.Transactional;
import jdk.swing.interop.SwingInterOpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Transactional
    public void guardarTopico(DatosRegistroTopico datosRegistroTopico) {
        Topico t1 = new Topico();
        t1.setTitulo(datosRegistroTopico.titulo());
        t1.setMensaje(datosRegistroTopico.mensaje());
        t1.setFechaCreacion(new Date());
        t1.setEstadoDelTopico("nuevo");
        Optional<Autor> a1 = autorRepository.findById(Long.parseLong(datosRegistroTopico.idUsuario()));
        if(a1.isPresent()) {
            Autor a2 = a1.get();
            t1.setAutor(a2);
        }
        Optional<Curso> c1 = cursoRepository.findByNombre(datosRegistroTopico.nombreCurso());
        if(c1.isPresent()) {
            Curso c2 = c1.get();
            t1.setCurso(c2);
        }
        topicoRepository.save(t1);
    }
}
