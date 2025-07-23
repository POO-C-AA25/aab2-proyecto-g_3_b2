package Modelo;
public class Pelicula3D extends Pelicula {
    public Pelicula3D(String titulo, String horario, String sala, Promocion promocion, String tipo) {
        super(titulo, horario, sala, promocion, tipo);
    }

    public double calcularPrecioBoleto() {
        return 6.5;
    }
}