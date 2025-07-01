package Utiles;

import Modelos.Cultivo;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestorCSV {

    public static List<Cultivo> leerDesdeCSV(String archivo) throws IOException {
        List<Cultivo> cultivos = new ArrayList<>();
        File file = new File(archivo);
        if (!file.exists()) {
            return cultivos; 
        }
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                Cultivo c = Cultivo.desdeCSV(linea);
                cultivos.add(c);
            }
        }
        return cultivos;
    }

    public static void guardarCultivosEnCSV(String archivo, List<Cultivo> cultivos) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(archivo))) {
            for (Cultivo c : cultivos) {
                pw.println(c.toCSV());
            }
            System.out.println("Cultivos guardados correctamente en el archivo.");
        }
    }
}
