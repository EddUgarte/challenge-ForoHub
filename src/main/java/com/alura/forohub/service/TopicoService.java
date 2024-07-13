package com.alura.forohub.service;

import com.alura.forohub.entity.*;
import com.alura.forohub.repository.AutorRepository;
import com.alura.forohub.repository.CursoRepository;
import com.alura.forohub.repository.TopicoRepository;
import jakarta.transaction.Transactional;
import jdk.swing.interop.SwingInterOpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
        try {
            //validarTitulo(datosRegistroTopico.titulo());
            t1.setTitulo(datosRegistroTopico.titulo());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException();
        }
        try {
            //validarMensaje(datosRegistroTopico.mensaje());
            t1.setMensaje(datosRegistroTopico.mensaje());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException();
        }
        t1.setFechaCreacion(new Date());
        t1.setEstadoDelTopico("nuevo");
        Optional<Autor> a1 = autorRepository.findById(Long.parseLong(datosRegistroTopico.idUsuario()));
        if(a1.isPresent()) {
            t1.setAutor(a1.get());
        }
        Optional<Curso> c1 = cursoRepository.findByNombre(datosRegistroTopico.nombreCurso());
        if(c1.isPresent()) {
            t1.setCurso(c1.get());
        }
        topicoRepository.save(t1);
    }


    public List<DatosListadoTopico> listarTopicos() {
        List<Topico> listaDeTopicos = topicoRepository.findAll();
        List<DatosListadoTopico> listaDeDatosListadoTopico = new ArrayList<>();
        for (int i = 0; i < listaDeTopicos.size(); i++) {
            DatosListadoTopico d1 = new DatosListadoTopico(listaDeTopicos.get(i));
            listaDeDatosListadoTopico.add(d1);
        }
        //System.out.println(listaDeDatosListadoTopico);
        return listaDeDatosListadoTopico;
    }

    public DatosRespuestaTopico encuentraTopicoPorId(Long id) {
        Optional<Topico> t1 = topicoRepository.findById(id);
        if(t1.isPresent()) {
            DatosRespuestaTopico datosTopico = new DatosRespuestaTopico(t1.get());
            return datosTopico;
        }
        return null;
    }
}
