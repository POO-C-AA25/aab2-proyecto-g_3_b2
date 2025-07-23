package Modelo;
import java.util.ArrayList;
public class Combo extends Snack{
    private ArrayList<Snack> snacksIncluidos;

    public Combo(String nombre, double precio, ArrayList<Snack> snacksIncluidos){
        super(nombre, precio);
        this.snacksIncluidos = snacksIncluidos;
    }

    public ArrayList<Snack> getSnacksIncluidos() {
        return snacksIncluidos;
    }

    public void setSnacksIncluidos(ArrayList<Snack> snacksIncluidos) {
        this.snacksIncluidos = snacksIncluidos;
    }

    @Override
    public double getPrecio() {
        return super.getPrecio();
    }
}
