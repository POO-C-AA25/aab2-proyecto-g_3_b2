package Modelo;
import java.io.*;
import java.util.ArrayList;

public class Cartelera {
    private ArrayList<Pelicula> peliculas = new ArrayList<>();

    public void cargarPeliculas(String archivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            br.readLine();
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                String titulo = datos[0];
                String horario = datos[1];
                String sala = datos[2];
                
                String diaPromo = (datos.length > 3 && !datos[3].isEmpty()) ? datos[3] : null;
                Double descuento = (datos.length > 4 && !datos[4].isEmpty()) ? Double.parseDouble(datos[4]) : null;
                String tipoPeli = (datos.length > 5 && !datos[5].isEmpty()) ? datos[5].toLowerCase() : "2d";
                
                Promocion promo = (diaPromo != null && descuento != null) ? new Promocion(diaPromo, descuento) : null;
                
                Pelicula p;
                if (tipoPeli.contains("3d")) {
                    p = new Pelicula3D(titulo, horario, sala, promo, tipoPeli);
                } else if (tipoPeli.toLowerCase().contains("estreno")) {
                    p = new Estreno(titulo, horario, sala, promo, tipoPeli);
                } else {
                    p = new Pelicula2D(titulo, horario, sala, promo, tipoPeli);
                }
                peliculas.add(p);
            }
        } catch (IOException e) {
            System.out.println("Error leyendo peliculas: " + e.getMessage());
        }
    }

    public ArrayList<Pelicula> obtenerPeliculas() {
        return peliculas;
    }
}