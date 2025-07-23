package Modelo;
public class Estreno extends Pelicula {
    public Estreno(String titulo, String horario, String sala, Promocion promocion, String tipo) {
        super(titulo, horario, sala, promocion, tipo);
    }

    public double calcularPrecioBoleto() {
        return 7.5;
    }
}