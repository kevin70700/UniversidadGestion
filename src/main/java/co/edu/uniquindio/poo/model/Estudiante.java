package co.edu.uniquindio.poo.model;
import java.util.*;
import javax.swing.*;

public class Estudiante {
    private String nombre;
    private String id;
    private List<Nota> notas;

    public Estudiante(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
        this.notas = new ArrayList<>();
    }

    public String getNombre() { return nombre; }
    public String getId() { return id; }

    public void agregarNota(Nota nota) {
        if (notas.size() < 5) {
            notas.add(nota);
            JOptionPane.showMessageDialog(null, "Nota agregada correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "El estudiante ya tiene 5 notas.");
        }
    }

    public void actualizarNota(String nombreNota, double nuevoValor) {
        for (Nota n : notas) {
            if (n.getNombre().equals(nombreNota)) {
                n.setValor(nuevoValor);
                JOptionPane.showMessageDialog(null, "Nota actualizada correctamente.");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Nota no encontrada.");
    }

    public double calcularPromedio() {
        if (notas.isEmpty()) return 0;
        return notas.stream().mapToDouble(Nota::getValor).average().orElse(0);
    }

    public String mostrarNotas() {
        StringBuilder sb = new StringBuilder("Estudiante: " + nombre + "\n");
        for (Nota n : notas) {
            sb.append(n.getNombre()).append(": ").append(n.getValor()).append("\n");
        }
        sb.append("Promedio: ").append(calcularPromedio()).append("\n");
        return sb.toString();
    }
}