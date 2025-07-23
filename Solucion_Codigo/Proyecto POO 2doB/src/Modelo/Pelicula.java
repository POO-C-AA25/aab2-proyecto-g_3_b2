package Modelo;
public abstract class Pelicula {
    private String titulo;
    private String horario;
    private String sala;
    private Promocion promocion;
    private String tipo;

    public Pelicula(String titulo, String horario, String sala, Promocion promocion, String tipo) {
        this.titulo = titulo;
        this.horario = horario;
        this.sala = sala;
        this.promocion = promocion;
        this.tipo = tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public Promocion getPromocion() {
        return promocion;
    }

    public void setPromocion(Promocion promocion) {
        this.promocion = promocion;
    }

     public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public abstract double calcularPrecioBoleto();
}