import java.util.ArrayList;
import java.util.Scanner;

public class MantenimientoInventario {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> nombres = new ArrayList<>();
        ArrayList<Integer> cantidades = new ArrayList<>();
        ArrayList<Double> precios = new ArrayList<>();

        System.out.println("=== INVENTARIO DE PRODUCTOS ===");

        int cantidadMinima;
        do {
            System.out.print("Ingrese cuántos productos desea agregar (mínimo 5): ");
            cantidadMinima = obtenerEntero(scanner);
            if (cantidadMinima < 5) {
                System.out.println(" Debe ingresar al menos 5 productos.");
            }
        } while (cantidadMinima < 5);

        for (int i = 0; i < cantidadMinima; i++) {
            System.out.println("\nProducto #" + (i + 1));
            String nombre = obtenerNombreProducto(scanner);
            int cantidad = obtenerEntero(scanner, "Cantidad del producto: ");
            double precio = obtenerDouble(scanner, "Precio unitario: ");

            nombres.add(nombre);
            cantidades.add(cantidad);
            precios.add(precio);
        }

        mostrarInventario(nombres, cantidades, precios, "Reporte inicial del inventario:");

        // Agregar más productos
        if (preguntarSi(scanner, "¿Desea agregar más productos? (sí/no): ")) {
            int contador = 0;
            do {
                contador++;
                System.out.println("\nNuevo producto #" + contador);
                String nombre = obtenerNombreProducto(scanner);
                int cantidad = obtenerEntero(scanner, "Cantidad del producto: ");
                double precio = obtenerDouble(scanner, "Precio unitario: ");

                nombres.add(nombre);
                cantidades.add(cantidad);
                precios.add(precio);
            } while (preguntarSi(scanner, "¿Desea agregar otro producto? (sí/no): "));
        }

        // Actualizar cantidades
        if (preguntarSi(scanner, "\n¿Desea actualizar la cantidad de un producto existente? (sí/no): ")) {
            do {
                String productoActualizar = obtenerNombreProducto(scanner, "Nombre del producto a actualizar: ");
                int nuevoValor = obtenerEntero(scanner, "Nueva cantidad: ");

                int indice = nombres.indexOf(productoActualizar);
                if (indice != -1) {
                    cantidades.set(indice, nuevoValor);
                    System.out.println(" Cantidad actualizada correctamente.");
                } else {
                    System.out.println(" Producto no encontrado.");
                }
            } while (preguntarSi(scanner, "¿Desea actualizar otro producto? (sí/no): "));
        }

        mostrarInventario(nombres, cantidades, precios, "\nReporte final del inventario actualizado:");
        scanner.close();
    }

    // FUNCIONES AUXILIARES

    public static String obtenerNombreProducto(Scanner scanner) {
        return obtenerNombreProducto(scanner, "Nombre del producto: ");
    }

    public static String obtenerNombreProducto(Scanner scanner, String mensaje) {
        String nombre;
        while (true) {
            System.out.print(mensaje);
            nombre = scanner.nextLine().trim();
            if (nombre.isEmpty()) {
                System.out.println(" El nombre no puede estar vacío.");
            } else if (nombre.matches("\\d+")) {
                System.out.println(" El nombre no puede ser solo números.");
            } else {
                break;
            }
        }
        return nombre;
    }

    public static int obtenerEntero(Scanner scanner) {
        return obtenerEntero(scanner, "");
    }

    public static int obtenerEntero(Scanner scanner, String mensaje) {
        int valor = -1;
        while (true) {
            try {
                if (!mensaje.isEmpty()) System.out.print(mensaje);
                valor = Integer.parseInt(scanner.nextLine().trim());
                if (valor >= 0) break;
                System.out.println(" Ingrese un número entero positivo.");
            } catch (NumberFormatException e) {
                System.out.println(" Entrada inválida. Ingrese un número entero.");
            }
        }
        return valor;
    }

    public static double obtenerDouble(Scanner scanner, String mensaje) {
        double valor = -1;
        while (true) {
            try {
                System.out.print(mensaje);
                valor = Double.parseDouble(scanner.nextLine().trim());
                if (valor >= 0) break;
                System.out.println(" Ingrese un número positivo.");
            } catch (NumberFormatException e) {
                System.out.println(" Entrada inválida. Ingrese un número decimal.");
            }
        }
        return valor;
    }

    public static boolean preguntarSi(Scanner scanner, String mensaje) {
        System.out.print(mensaje);
        String respuesta = scanner.nextLine().trim().toLowerCase();
        return respuesta.equals("si") || respuesta.equals("sí");
    }

    public static void mostrarInventario(ArrayList<String> nombres, ArrayList<Integer> cantidades, ArrayList<Double> precios, String titulo) {
        System.out.println("\n=== " + titulo + " ===");
        double total = 0.0;
        for (int i = 0; i < nombres.size(); i++) {
            double valorTotal = cantidades.get(i) * precios.get(i);
            total += valorTotal;
            System.out.printf("Producto: %-15s | Cantidad: %-5d | Precio: $%-8.2f | Total: $%.2f%n",
                    nombres.get(i), cantidades.get(i), precios.get(i), valorTotal);
        }
        System.out.printf(" Valor total del inventario: $%.2f%n", total);
    }
}
