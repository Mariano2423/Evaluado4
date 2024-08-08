/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package evaluado4;

import javax.swing.JOptionPane;

/**
 *
 * @author Aulas Heredia
 */
public class Gestion {
    public Estudiante[] estudiantes;

    public Gestion(int tamano) {
        estudiantes = new Estudiante[tamano];
    }

    public void agreEstudiante() {
        for (int i = 0; i < estudiantes.length; i++) {
            String nombre = JOptionPane.showInputDialog("Escriba el nombre del estudiante:");
            String curso = JOptionPane.showInputDialog("Escriba el curso del estudiante:");
            String profesor = JOptionPane.showInputDialog("Escriba el nombre del profesor:");
            int nota = Integer.parseInt(JOptionPane.showInputDialog("Escriba la nota final del estudiante:"));

            estudiantes[i] = new Estudiante(nombre, curso, profesor, nota);
        }
    }

    public void mostrarInfo() {
        String info = "Listado de estudiantes: " + "\n";
        for (int x = 0; x < estudiantes.length; x++) {
            Estudiante estudiante = estudiantes[x];
            if (estudiante != null) {
                info += "Nombre: " + estudiante.getNombreEstudiante() + ", Curso: " + estudiante.getCurso() + ", Profesor: " + estudiante.getProfesor()+ ", Nota: " + estudiante.getCalificacion() + "\n";
            }
        }
        JOptionPane.showMessageDialog(null, info);
    }

    public void mostrarCalificaciones() {
        int cantidad = 0;
        int sumatotal = 0;
        int notaMayor = 0;
        int notaMenor = 100;
        int mayorPromedio = 0;
        int menorPromedio = 0;

        for (int x = 0; x < estudiantes.length; x++) {
            Estudiante estudiante = estudiantes[x];
            if (estudiante != null) {
                int calificacion = estudiante.getCalificacion();
                sumatotal = sumatotal + calificacion;
                cantidad++;

                if (calificacion > notaMayor) {
                    notaMayor = calificacion;
                }
                if (calificacion < notaMenor) {
                    notaMenor = calificacion;
                }
            }
        }

        if (cantidad > 0) {
            int promedio = sumatotal / cantidad;

            String mayoresPromedio = "Notas por arriba del Promedio";
            String menoresPromedio = "Notas por abajo del promedio ";

            for (int i = 0; i < estudiantes.length; i++) {
                Estudiante estudiante = estudiantes[i];
                if (estudiante != null) {
                    int calificacion = estudiante.getCalificacion();
                    if (calificacion > promedio) {
                        mayoresPromedio += estudiante.getNombreEstudiante() + " - " + calificacion + "\n";
                        mayorPromedio++;
                    } else if (calificacion < promedio) {
                        menoresPromedio += estudiante.getNombreEstudiante() + " - " + calificacion + "\n";
                        menorPromedio++;
                    }
                }
            }

            String EstuMayor = "El  estudiante con mejor nota ";
            String EstuMenor = "El estudiante con peor nota  ";
            for (int x = 0; x < estudiantes.length; x++) {
                Estudiante estudiante = estudiantes[x];
                if (estudiante != null) {
                    if (estudiante.getCalificacion() == notaMayor) {
                        EstuMayor += estudiante.getNombreEstudiante() + " (" + notaMayor + ")\n";
                    }
                    if (estudiante.getCalificacion() == notaMenor) {
                        EstuMenor += estudiante.getNombreEstudiante() + " (" + notaMenor + ")\n";
                    }
                }
            }

            JOptionPane.showMessageDialog(null, EstuMayor);
            JOptionPane.showMessageDialog(null, EstuMenor);
            JOptionPane.showMessageDialog(null, "Promedio de las notas: " + promedio);
            JOptionPane.showMessageDialog(null, mayoresPromedio);
            JOptionPane.showMessageDialog(null, menoresPromedio);
        } else {
            JOptionPane.showMessageDialog(null, "No hay estudiantes");
        }
    }
}
