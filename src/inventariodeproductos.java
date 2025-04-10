import java.util.ArrayList;
import java.util.Scanner;

public class inventariodeproductos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> nombres = new ArrayList<>();
        ArrayList<Integer> cantidades = new ArrayList<>();
        ArrayList<Double> precios = new ArrayList<>();
        ArrayList<Double> valoresTotales = new ArrayList<>();

        int cantidadMinima = 1;
        System.out.print("¿Cuántos productos vas a agregar? (mínimo " + cantidadMinima + "): ");
        int cantidad = scanner.nextInt();
        scanner.nextLine();

        while (cantidad < cantidadMinima) {
            System.out.print("Debes agregar al menos " + cantidadMinima + " productos: ");
            cantidad = scanner.nextInt();
            scanner.nextLine();
        }

        for (int i = 0; i < cantidad; i++) {
            System.out.print("Nombre del producto " + (i + 1) + ": ");
            nombres.add(scanner.nextLine());

            System.out.print("Cantidad: ");
            cantidades.add(scanner.nextInt());

            System.out.print("Precio: ");
            precios.add(scanner.nextDouble());
            scanner.nextLine(); // Limpiar el buffer
        }

        String respuesta;
        do {
            System.out.print("¿Quieres agregar más productos? (si/no): ");
            respuesta = scanner.nextLine().trim().toLowerCase();

            if (respuesta.equals("si")) {
                System.out.print("Nombre del producto: ");
                nombres.add(scanner.nextLine());

                System.out.print("Cantidad: ");
                cantidades.add(scanner.nextInt());

                System.out.print("Precio: ");
                precios.add(scanner.nextDouble());
                scanner.nextLine();
            }

        } while (respuesta.equals("si"));

        do {
            System.out.print("¿Quieres actualizar la cantidad de un producto? (si/no): ");
            respuesta = scanner.nextLine().trim().toLowerCase();

            if (respuesta.equals("si")) {
                System.out.print("Nombre del producto a actualizar: ");
                String nombreActualizar = scanner.nextLine();
                int indice = -1;

                for (int i = 0; i < nombres.size(); i++) {
                    if (nombres.get(i).equalsIgnoreCase(nombreActualizar)) {
                        indice = i;
                        break;
                    }
                }

                if (indice != -1) {
                    System.out.print("Nueva cantidad: ");
                    int nuevaCantidad = scanner.nextInt();
                    cantidades.set(indice, nuevaCantidad);
                    scanner.nextLine();
                } else {
                    System.out.println("Producto no encontrado.");
                }
            }

        } while (respuesta.equals("si"));

        // Calcular valores totales
        double inventarioTotal = 0;
        for (int i = 0; i < nombres.size(); i++) {
            double valor = cantidades.get(i) * precios.get(i);
            valoresTotales.add(valor);
            inventarioTotal += valor;
        }

        // Mostrar resultados
        System.out.println("\nInventario final:");
        for (int i = 0; i < nombres.size(); i++) {
            System.out.println("Producto: " + nombres.get(i));
            System.out.println("Cantidad: " + cantidades.get(i));
            System.out.println("Precio: " + precios.get(i));
            System.out.println("Valor total: " + valoresTotales.get(i));
            System.out.println("--------------------------");
        }

        System.out.println("Valor total del inventario: " + inventarioTotal);
    }
}

