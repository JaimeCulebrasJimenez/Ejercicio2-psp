package ejercicio2_psp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio2_psp {

    /*
    Hacer media de alumno y media de las asignaturas, varios alumnos con una nota en cada una de las asignaturas.
     */

    static void HacerMediaAlumno(File alumno) {
        
        String Texto;
        
        if (alumno.isDirectory()) {
            File notas = new File(alumno.getAbsolutePath() + System.getProperty("file.separator") + "notas.txt");

            System.out.println(notas.getAbsolutePath());
            try (BufferedReader reader = new BufferedReader(new FileReader(notas))) {

                while ((Texto = reader.readLine()) != null) {
                    System.out.println(Texto);
                }

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public static void main(String[] args) {
        File ruta = new File("D:\\Users\\jaime.culjim\\Documents\\NetBeansProjects\\Ejercicio2_psp\\Alumnos");
        File[] alumnos = ruta.listFiles();

        for (File alumno : alumnos) {
            HacerMediaAlumno(alumno);
        }

    }

}
