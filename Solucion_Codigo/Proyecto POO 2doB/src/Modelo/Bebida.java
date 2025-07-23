package Modelo;
public class Bebida extends Snack{
    private int cantidadML;

    public Bebida(String nombre, double precio, int cantidadML) {
        super(nombre, precio);
        this.cantidadML = cantidadML;
    }

    public int getCantidadML() {
        return cantidadML;
    }

    public void setCantidadML(int cantidadML) {
        this.cantidadML = cantidadML;
    }
}