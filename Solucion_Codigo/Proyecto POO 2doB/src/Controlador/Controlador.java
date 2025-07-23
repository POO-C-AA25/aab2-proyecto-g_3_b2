package Controlador;
import Modelo.*;
import Vista.Vista;
import java.util.ArrayList;
import java.util.Scanner;

public class Controlador {
    private final Cartelera cartelera;
    private final Facturacion facturacion;
    private final Vista vista;
    private final ArrayList<Promocion> promociones;
    private final Scanner sc;
    private final ListSnacks listaSnacks;

    public Controlador() {
        this.cartelera = new Cartelera();
        this.facturacion = new Facturacion();
        this.vista = new Vista();
        this.promociones = new ArrayList<>();
        this.sc = new Scanner(System.in);
        this.listaSnacks = new ListSnacks();
    }

    public void iniciar() {
        cartelera.cargarPeliculas("peliculas.csv");
        listaSnacks.cargarSnacksDesdeCSV("snacks.csv");

        promociones.clear();
        promociones.add(new Promocion("Lunes", 2));
        promociones.add(new Promocion("Viernes", 5));
        promociones.add(new Promocion("Sabado", 3));

        mostrarPeliculas();
        realizarVenta();
    }

    public void mostrarPeliculas() {
        vista.mostrarPeliculas(cartelera.obtenerPeliculas());
        vista.mostrarPromociones(promociones);
    }

    public void realizarVenta() {
        System.out.print("Seleccione una pelicula (numero): ");
        int indice = sc.nextInt();
        
        if (indice < 1 || indice > cartelera.obtenerPeliculas().size()) {
            System.out.println("Número de película inválido!");
            return;
        }
        
        Pelicula seleccionada = cartelera.obtenerPeliculas().get(indice - 1);
        facturacion.seleccionarPelicula(seleccionada);
        
        System.out.print("Cantidad de boletos: ");
        int cantidad = sc.nextInt();
        
        if (cantidad <= 0) {
            System.out.println("La cantidad debe ser mayor a 0");
            return;
        }
        
        facturacion.seleccionarCantidad(cantidad);
        
        ArrayList<Snack> snacks = vista.solicitarSnacksDisponibles(listaSnacks.listaSnacks());
        for (Snack s : snacks) {
            facturacion.agregarSnack(s);
        }
        
        double total = facturacion.calcularTotal();
        vista.mostrarFactura(seleccionada, cantidad, snacks, total);
        
        Venta venta = new Venta(seleccionada, cantidad, snacks, total);
        System.out.println("¡Venta realizada con éxito!");
    }
}