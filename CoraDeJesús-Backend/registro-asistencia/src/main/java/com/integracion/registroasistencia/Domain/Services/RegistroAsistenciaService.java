package com.integracion.registroasistencia.Domain.Services;

import com.integracion.registroasistencia.Domain.Entities.Bimestre;
import com.integracion.registroasistencia.Domain.Entities.Estudiante;
import com.integracion.registroasistencia.Domain.Entities.Grado;
import com.integracion.registroasistencia.Domain.Entities.RegistroAsistencia;
import com.integracion.registroasistencia.Domain.Repositories.RegistroAsistenciaRepository;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegistroAsistenciaService {

    private final RegistroAsistenciaRepository registroAsistenciaRepository;

    public List<Object> getNumeroFaltas(String bimestre, int anio) {
        return registroAsistenciaRepository.getFaltasBySexto(bimestre, anio);
    }


    public RegistroAsistenciaService(RegistroAsistenciaRepository registroAsistenciaRepository) {
        this.registroAsistenciaRepository = registroAsistenciaRepository;
    }



    public RegistroAsistencia crearRegistroAsistencia(RegistroAsistencia RegistroAsistencia) {
        return registroAsistenciaRepository.save(RegistroAsistencia);
    }

    public RegistroAsistencia modificarRegistroAsistencia(RegistroAsistencia RegistroAsistencia) {
        return registroAsistenciaRepository.save(RegistroAsistencia);
    }

    public void eliminarRegistroAsistencia(Integer idRegistroAsistencia) {
        registroAsistenciaRepository.deleteById(idRegistroAsistencia);
    }

    public List<RegistroAsistencia> listarRegistroAsistencia() {
        return registroAsistenciaRepository.findAll();
    }

    public List<RegistroAsistencia> findAllbyBimestre(Bimestre bimestre) {
        return registroAsistenciaRepository.findAllByBimestre(bimestre);
    }
    public List<RegistroAsistencia> findAllByEstudiante(Estudiante estudiante){
        return registroAsistenciaRepository.findAllByEstudiante(estudiante);
    }
    public List<RegistroAsistencia> obtenerPorEstudianteBimestre(Estudiante estudiante, Bimestre bimestre){

        List<RegistroAsistencia> todos = registroAsistenciaRepository.findAllByEstudiante(estudiante);
        List<RegistroAsistencia> porBimestre = todos.stream().filter(
                a -> a.getBimestre().equals(bimestre)).collect(Collectors.toList());
        return porBimestre;

    }

    public List<RegistroAsistencia> obtenerPorGrado(Grado grado){

        List<RegistroAsistencia> todos = registroAsistenciaRepository.findAll();
        List<RegistroAsistencia> porGrado = todos.stream().filter(
                a -> a.getEstudiante().getRegistrogrado().contains(grado)).collect(Collectors.toList());
        return porGrado;

    }

    public List<RegistroAsistencia> obtenerPorGradoYFecha(Grado grado, Date date){

        DateFormat formatter1 = new SimpleDateFormat("dd-MM-yyyy");
        String date1=formatter1.format(date);

        List<RegistroAsistencia> todos = registroAsistenciaRepository.findAll();
        List<RegistroAsistencia> porGrado = todos.stream().filter(
                a -> a.getEstudiante().getRegistrogrado().contains(grado)).collect(Collectors.toList());
        List<RegistroAsistencia> porFecha= porGrado.stream().filter(
                a-> a.getFecha().equals(date1)).collect(Collectors.toList());
        System.out.println(date1);

        return porFecha;


    }

    public List<RegistroAsistencia> findAllByFecha(Date fecha){
        return registroAsistenciaRepository.findAllByFecha(fecha);
    }

    public List<RegistroAsistencia> findAllByFechaAndAndEstudiante(Date fecha, Estudiante estudiante){
        return registroAsistenciaRepository.findAllByFechaAndAndEstudiante(fecha, estudiante);
    }


    public RegistroAsistencia obtenerRegistroAsistenciaPorIdRegistroAsistencia(Integer idRegistroAsistencia) {
        return registroAsistenciaRepository.findById(idRegistroAsistencia).orElse(new RegistroAsistencia());
    }
}
