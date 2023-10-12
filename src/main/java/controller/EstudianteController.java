package controller;

import modelo.*;
import modelo.data.*;
import modelo.data.dao.*;
import org.jooq.DSLContext;

public class EstudianteController {

    public static boolean registrarEstudiante(String nombre,String apellido ,String rut, String matricula, String codigoCarrera) throws ClassNotFoundException {
        DSLContext query = DBGenerator.conectarBD("Universidad");
        if(!EstudianteDAO.validarExistenciaEstudiante(query,"rut",rut)){
            Carrera carrera =CarreraDAO.buscarCarrera(query,codigoCarrera);
            Estudiante estudiante= new Estudiante(nombre,apellido,rut,matricula,carrera);
            EstudianteDAO.agregarEstudiante(query,estudiante);
            DBConnector.closeConnection();
            return true;
        }
        else{
            DBConnector.closeConnection();
            return false;
        }
    }
    public static String[][] mostrarEstudiantesPorCarrera(String codigo) throws ClassNotFoundException {
        DSLContext query = DBGenerator.conectarBD("Universidad");
        String[][] datosEstudiantes= EstudianteDAO.obtenerEstudiantesCursoCodigo(query,codigo);
        DBConnector.closeConnection();
        return datosEstudiantes;
    }
    public static String[][] mostrarEstudiantesPorNombre(String codigo, String nombre) throws ClassNotFoundException {
        DSLContext query = DBGenerator.conectarBD("Universidad");
        String[][] datosEstudiantes = EstudianteDAO.obtenerEstudiantesCursoNombre(query,nombre,codigo);
        DBConnector.closeConnection();
        return datosEstudiantes;
    }
}
