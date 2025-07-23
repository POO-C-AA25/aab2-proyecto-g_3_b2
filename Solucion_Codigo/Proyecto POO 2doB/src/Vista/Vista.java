package Vista;
import Modelo.Pelicula;
import Modelo.Promocion;
import Modelo.Snack;

import java.util.ArrayList;
import java.util.Scanner;

public class Vista {
    public Scanner sc = new Scanner(System.in);

    public void mostrarPeliculas(ArrayList<Pelicula> peliculas) {
        System.out.println("+===================================================================+");
        System.out.println("|                    C I N E M A S   -   L O J A                    |");
        System.out.println("+===================================================================+");
        System.out.println("| Películas disponibles:                                            |");
        System.out.println("|-------------------------------------------------------------------|");

        for (int i = 0; i < peliculas.size(); i++) {
            Pelicula p = peliculas.get(i);
            System.out.printf("| %-2d. %-20s | Hora: %-5s | %-7s | Tipo: %-8s |\n",
                            (i + 1),
                            p.getTitulo(),
                            p.getHorario(),
                            p.getSala(),
                            p.getTipo().toUpperCase());
        }
        System.out.println("+-------------------------------------------------------------------+");
    }

    public void mostrarPromociones(ArrayList<Promocion> promociones) {
        if (promociones.isEmpty()) return;
        System.out.println("| Promociones disponibles:                                          |");
        System.out.println("|-------------------------------------------------------------------|");
        for (Promocion promo : promociones) {
            System.out.printf("| Día: %-10s                 | Descuento: %.1f%%                 |\n",
                            promo.getDia(),
                            promo.getDescuento());
        }
        System.out.println("+-------------------------------------------------------------------+\n");
    }

    public ArrayList<Snack> solicitarSnacksDisponibles(ArrayList<Snack> menu) {
        ArrayList<Snack> snacksElegidos = new ArrayList<>();

        System.out.println("\n+--------------------+");
        System.out.println("| Menu de Snacks     |");
        System.out.println("+--------------------+");
        
        for (int i = 0; i < menu.size(); i++) {
            Snack s = menu.get(i);
            System.out.println((i + 1) + ". " + s.getNombre() + " - $" + s.getPrecio());
        }

        while (true) {
            System.out.print("Seleccione snack (0 para finalizar): ");
            int opcion = sc.nextInt();
            
            if (opcion == 0) {
                break;
            }
            
            if (opcion >= 1 && opcion <= menu.size()) {
                snacksElegidos.add(menu.get(opcion - 1));
                System.out.println("Agregado: " + menu.get(opcion - 1).getNombre());
            } else {
                System.out.println("Opcion invalida. Ingrese un número entre 0 y " + menu.size());
            }
        }
        return snacksElegidos;
    }

    public void mostrarFactura(Pelicula p, int boletos, ArrayList<Snack> snacks, double total) {
        System.out.println("\n+--------------------+");
        System.out.println("|    FACTURA FINAL   |");
        System.out.println("+--------------------+");
        System.out.println("Pelicula: " + p.getTitulo());
        System.out.println("Horario: " + p.getHorario());
        System.out.println("Sala: " + p.getSala());
        System.out.println("Tipo: " + p.getTipo().toUpperCase());
        System.out.println("Boletos: " + boletos + " x $" + p.calcularPrecioBoleto());
        
        System.out.print("Snacks: ");
        if (snacks.isEmpty()) {
            System.out.println("Ninguno");
        } else {
            for (int i = 0; i < snacks.size(); i++) {
                System.out.print(snacks.get(i).getNombre());
                if (i < snacks.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }

        double precioBoletos = boletos * p.calcularPrecioBoleto();
        double precioSnacks = 0.0;
        for (Snack s : snacks) {
            precioSnacks += s.getPrecio();
        }
        double subtotal = precioBoletos + precioSnacks;

        System.out.printf("Subtotal boletos: $%.2f\n", precioBoletos);
        System.out.printf("Subtotal snacks: $%.2f\n", precioSnacks);
        System.out.printf("Subtotal: $%.2f\n", subtotal);

        if (p.getPromocion() != null) {
            double descuentoAplicado = subtotal * (p.getPromocion().getDescuento() / 100);
            System.out.printf("Descuento (%s - %.1f%%): -$%.2f\n",
                    p.getPromocion().getDia(), 
                    p.getPromocion().getDescuento(), 
                    descuentoAplicado);
        }

        System.out.println("===========================");
        System.out.printf("TOTAL A PAGAR: $%.2f\n", total);
        System.out.println("===========================");
    }
}