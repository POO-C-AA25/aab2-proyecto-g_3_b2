package Modelo;
public class Comida extends Snack{
    private String tipo;

    public Comida(String nombre, double precio, String tipo){
        super(nombre, precio);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
