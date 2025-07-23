package Modelo;
public class Pelicula2D extends Pelicula {
    public Pelicula2D(String titulo, String horario, String sala, Promocion promocion, String tipo) {
        super(titulo, horario, sala, promocion, tipo);
    }

    public double calcularPrecioBoleto() {
        return 5.5;
    }
}