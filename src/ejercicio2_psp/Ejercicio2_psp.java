package ejercicio2_psp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Ejercicio2_psp {

    /*
    Hacer media de alumno y media de las asignaturas, varios alumnos con una nota en cada una de las asignaturas.
     */

    //Hace una media a partir de un arraylist
    static int media(ArrayList<Integer> Lista) {
        int Notas = 0;
        int NumNotas = 0;
        for (int i = 0; i < Lista.size(); i++) {
            Notas += Lista.get(i);
            NumNotas = i + 1;
        }
        return Notas / NumNotas;
    }

    //Hacer la media de notas de un directorio alumno
    static int HacerMediaAlumno(File alumno) {

        String Texto;
        ArrayList<Integer> ListaNotas = new ArrayList<Integer>();

        if (alumno.isDirectory()) {
            File notas = new File(alumno.getAbsolutePath() + System.getProperty("file.separator") + "notas.txt");

            try (BufferedReader reader = new BufferedReader(new FileReader(notas))) {

                while ((Texto = reader.readLine()) != null) {
                    String[] TextoSplit = Texto.split(" ");
                    ListaNotas.add(Integer.parseInt(TextoSplit[1]));
                }

                return media(ListaNotas);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return 0;

    }

    //Hacer media de las asignaturas
    static void HacerMediaAsignaturas(File ruta) {

        String Texto;
        Map<String, ArrayList<Integer>> MapaNotas = new HashMap<>();

        File[] alumnos = ruta.listFiles();
        for (File alumno : alumnos) {
            File notas = new File(alumno.getAbsolutePath() + System.getProperty("file.separator") + "notas.txt");
            if (notas.isFile() && notas.exists()) {

                try (BufferedReader reader = new BufferedReader(new FileReader(notas))) {

                    while ((Texto = reader.readLine()) != null) {
                        String[] TextoSplit = Texto.split(" ");

                        if (!MapaNotas.containsKey(TextoSplit[0])) {
                            MapaNotas.put(TextoSplit[0], new ArrayList<>());
                        }
                        MapaNotas.get(TextoSplit[0]).add(Integer.parseInt(TextoSplit[1]));
                        
                    }
                    
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }

            }
            
            
        }
        
        for (Map.Entry<String, ArrayList<Integer>> entry : MapaNotas.entrySet()) {
            String key = entry.getKey();
            ArrayList<Integer> value = entry.getValue();
            int mediaAsignatura = media(value);
            System.out.println("media de: " + key + " " + mediaAsignatura);
            
        }

    }

    public static void main(String[] args) {
        File ruta = new File("D:\\Users\\jaime.culjim\\Documents\\NetBeansProjects\\Ejercicio2_psp\\Alumnos");
        File[] alumnos = ruta.listFiles();

       for (File alumno : alumnos) {
            System.out.println(alumno.getAbsolutePath());
            System.out.println(HacerMediaAlumno(alumno));
        }

        HacerMediaAsignaturas(ruta);

    }// main

}// clase
