package co.edu.uniquindio.poo.app;

import co.edu.uniquindio.poo.model.*;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Universidad universidad = new Universidad();

        while (true) {
            String opcionStr = JOptionPane.showInputDialog(null, "Menú:\n1. Registrar estudiante\n2. Agregar nota a estudiante\n3. Obtener estudiante con mayor promedio\n4. Actualizar nota de estudiante\n5. Mostrar notas y promedio de cada estudiante\n6. Mostrar lista de estudiantes con promedios\n7. Mejor estudiante por nota\n8. Salir", "Gestión de Estudiantes", JOptionPane.QUESTION_MESSAGE);
            if (opcionStr == null) break;
            int opcion;
            try {
                opcion = Integer.parseInt(opcionStr);
            } catch (NumberFormatException e) {
                continue;
            }

            switch (opcion) {
                case 1:
                    String nombre = JOptionPane.showInputDialog("Ingrese nombre del estudiante:");
                    String id = JOptionPane.showInputDialog("Ingrese identificación del estudiante:");
                    universidad.registrarEstudiante(new Estudiante(nombre, id));
                    break;
                case 2:
                    id = JOptionPane.showInputDialog("Ingrese ID del estudiante:");
                    String nombreNota = JOptionPane.showInputDialog("Ingrese nombre de la nota:");
                    String valorNotaStr = JOptionPane.showInputDialog("Ingrese valor de la nota:");
                    double valorNota;
                    try {
                        valorNota = Double.parseDouble(valorNotaStr);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Valor inválido.");
                        break;
                    }
                    universidad.agregarNotaEstudiante(id, new Nota(nombreNota, valorNota));
                    break;
                case 3:
                    Estudiante mejorEstudiante = universidad.obtenerMejorEstudiante();
                    String mensaje = (mejorEstudiante != null) ? "Mejor estudiante: " + mejorEstudiante.getNombre() + " con promedio " + mejorEstudiante.calcularPromedio() : "No hay estudiantes registrados.";
                    JOptionPane.showMessageDialog(null, mensaje);
                    break;
                case 4:
                    id = JOptionPane.showInputDialog("Ingrese ID del estudiante:");
                    nombreNota = JOptionPane.showInputDialog("Ingrese nombre de la nota a actualizar:");
                    valorNotaStr = JOptionPane.showInputDialog("Ingrese nuevo valor de la nota:");
                    try {
                        valorNota = Double.parseDouble(valorNotaStr);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Valor inválido.");
                        break;
                    }
                    universidad.actualizarNotaEstudiante(id, nombreNota, valorNota);
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, universidad.mostrarNotasYPromedios());
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, universidad.mostrarListaEstudiantes());
                    break;
                case 7:
                    JOptionPane.showMessageDialog(null, "Saliendo...");
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida.");

                case 8:
                    String indiceStr = JOptionPane.showInputDialog("Ingrese el número de la nota a analizar (1 a 5):");
                    int indiceNota;
                    try {
                        indiceNota = Integer.parseInt(indiceStr) - 1;
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Número inválido.");
                        break;
                    }
                    Estudiante mejorEstudianteNota = universidad.obtenerMejorEstudiantePorNota(indiceNota);
                    String mensajeNota = (mejorEstudianteNota != null) ?
                            "Mejor estudiante en esa nota: " + mejorEstudianteNota.getNombre() + " con nota " + mejorEstudianteNota.getNotas().get(indiceNota).getValor()
                            : "No hay estudiantes o la posición de la nota es incorrecta.";
                    JOptionPane.showMessageDialog(null, mensajeNota);
                    break;
            }

        }
    }
}
