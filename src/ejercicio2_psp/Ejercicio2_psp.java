package ejercicio2_psp;

import java.io.File;

public class Ejercicio2_psp {
    /*
    Hacer media de alumno y media de las asignaturas, varios alumnos con una nota en cada una de las asignaturas.
    */
    
    static void HacerMediaAlumno(File alumno) {
    
    if (alumno.isDirectory()) {
        File notas = new File(alumno.getAbsolutePath() + System.getProperty("file.separator") + "notas.txt");
        
        System.out.println(notas.getAbsolutePath());
        try {
            
        } catch (Exception e) {
            
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
