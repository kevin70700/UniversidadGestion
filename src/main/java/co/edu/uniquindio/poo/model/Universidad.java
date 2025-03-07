package co.edu.uniquindio.poo.model;
import java.util.*;
import javax.swing.JOptionPane;

public class Universidad {
    private List<Estudiante> estudiantes;

    public Universidad() {
        this.estudiantes = new ArrayList<>();
    }

    public void registrarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
        JOptionPane.showMessageDialog(null, "Estudiante registrado exitosamente.");
    }

    public void agregarNotaEstudiante(String id, Nota nota) {
        for (Estudiante estudianteaux : estudiantes) {
            if (estudianteaux.getId().equals(id)) {
                estudianteaux.agregarNota(nota);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Estudiante no encontrado.");
    }

    public Estudiante obtenerMejorEstudiante() {
        return estudiantes.stream().max(Comparator.comparingDouble(Estudiante::calcularPromedio)).orElse(null);
    }

    public void actualizarNotaEstudiante(String id, String nombreNota, double nuevoValor) {
        for (Estudiante e : estudiantes) {
            if (e.getId().equals(id)) {
                e.actualizarNota(nombreNota, nuevoValor);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Estudiante no encontrado.");
    }

    public String mostrarNotasYPromedios() {
        StringBuilder sb = new StringBuilder();
        for (Estudiante e : estudiantes) {
            sb.append(e.mostrarNotas()).append("\n");
        }
        return sb.toString();
    }

    public String mostrarListaEstudiantes() {
        StringBuilder sb = new StringBuilder();
        for (Estudiante e : estudiantes) {
            sb.append(e.getNombre()).append(" - Promedio: ").append(e.calcularPromedio()).append("\n");
        }
        return sb.toString();
    }
}

