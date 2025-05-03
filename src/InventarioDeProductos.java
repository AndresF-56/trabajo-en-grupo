//importamos las librerias de Scanner y Arraylist con las que trabajarémos.
import java.util.Scanner;
import java.util.ArrayList;

public class InventarioDeProductos {
    public static void main(String[] args) {
        //crear los arrays y cargar los datos para almenos 5 productos

        // se inicializa el scanner
        Scanner scanner = new Scanner(System.in);
        // se crea el array para los nombres de los productos.
        ArrayList<String> strNombres = new ArrayList<>();
        // se crea el array para las cantidades de cada producto.
        ArrayList<Integer> numCantidades = new ArrayList<>();
        //se crea el array para los precios de los productos.
        ArrayList<Double> numPrecios = new ArrayList<>();

        //preguntarle al usuario la cantidad de productos que desea agregar.
        //se evalua que se cumpla la condición de que sea como mínimo 5 productos.
        System.out.println("INVENTARIO DE PRODUCTOS");
        int cantidadMinima ;
        do {
            System.out.println("Por favor Ingrese al menos 5 productos:");
            cantidadMinima = scanner.nextInt();
            scanner.nextLine();
            if (cantidadMinima < 5) {
            System.out.println("Debe ingresar al menos 5 productos.");
            }
        } while (cantidadMinima < 5);


        //llenar los arrays con los 5 o más productos.
        for(int i = 0 ; i < cantidadMinima ; i++){

            // se hace la lectura del nombre de cada producto y se almacena en el array de nombres.
            System.out.println("ingrese el nombre del "+(i+1)+"° producto :");
            String strNombre = scanner.nextLine();
            strNombres.add(strNombre);

            // se hace la lectura de la cantidad de cada producto.
            System.out.println("ingrese la cantidad del "+(1+i)+"° producto : ");
            int numCantidad = scanner.nextInt();
            numCantidades.add(numCantidad);

            // se hace la lectura de el precio unitario de cada producto.
            System.out.println("ingrese el precio unitario del "+(1+i)+"° producto : ");
            double numPrecio = scanner.nextDouble();
            numPrecios.add(numPrecio);
            scanner.nextLine();

        }

        //array para almacenar los valores totales para los primeros productos.
        double[] valores_totales = new double[strNombres.size()];

        //variable para el inventario para los primeros productos.
        double inventario1 = 0.0d;

        //cálculo de valores totales e inventario para los 5 o más productos minimos.
        //incluye el primer reporte de los datos de inventario.
        System.out.println("El reporte del inventario con los productos hasta ahora ingresados es :");
        for(int i = 0 ; i < strNombres.size() ; i++){
            valores_totales[i] = numCantidades.get(i) * numPrecios.get(i);
            inventario1 += valores_totales[i];
            System.out.println("producto : "+strNombres.get(i)+" - Cantidad : "+numCantidades.get(i)+" - Precio por unidad : "+numPrecios.get(i)+" - Valor Total : "+valores_totales[i]);
        }

        //muestra el primer reporte del inventario.
        System.out.println("el valor total del inventario con los primeros productos : "+inventario1);

        //PERMITIR AGREGAR MAS PRODUCTOS

        //se le pregunta al usuario si desea agregar mas productos.
        System.out.println("¿Desea agregar mas productos al inventario?");

        // se lee la respuesta y se hace que la respuesta sea sin espacios y en minúscula
        String strRespuesta = scanner.nextLine().trim().toLowerCase();

        // comprobar cual fue la respuesta del usuario (si o no )
        if(strRespuesta.equals("si")){
            String strRespuesta2;
            int contador = 0;
            //se agrega un nuvo producto 
            do{
                //cuenta la cantidad de productos que va agregando el usuario
                contador++;

                //pide el nombre del nuevo producto
                System.out.println("ingrese el nombre del "+contador+"° producto que desea agregar :");
                String strNombre = scanner.nextLine();
                strNombres.add(strNombre);

                //pide la cantiddad del nuevo producto
                System.out.println("ingrese la cantidad de dicho producto :");
                int numCantidad = scanner.nextInt();
                numCantidades.add(numCantidad);

                //pide el precio del nuevo producto.
                System.out.println("finalmente ingrese el precio unitario del producto :");
                double numPrecio = scanner.nextDouble();
                numPrecios.add(numPrecio);
                scanner.nextLine();

                //se le pregunta al usuario si desea seguir agregando productos.
                System.out.println("¿desea agregar otro producto? responda si o no.");
                strRespuesta2 = scanner.nextLine().trim().toLowerCase();

            }while(strRespuesta2.equals("si"));
        }

            //ACTUALIZAR LA CANTIDAD DE UN PRODUCTO SI LLEGA MAS INVENTARIO.

            //se le pregunta al usuario.
            System.out.println("¿Desea actualizar la cantidad de un producto?");
            strRespuesta = scanner.nextLine().trim().toLowerCase();

            //se comprueba si su respuesta es si o no
            if(strRespuesta.equals("si")){

                String strRespuesta3;
                do{
                //se le pregunta al usuario.
                System.out.println("¿Cuál es el producto al que desea actualizar su cantidad?");
                String nombre = scanner.nextLine();

                //se le pregunta al usario la cantidad nueva del producto.
                System.out.println("¿Cuál es el valor por el que desea actualizar la cantidad de dicho producto? ");
                int nuevaCantidad = scanner.nextInt();
                scanner.nextLine();

                /*se recorre el array de los nommbres de los productos para hallar en que posicion se en
                 * que posicion se encuentra el producto solicitado. y se guarda esa posicion en la variable indice.
                */
                int indice = -1;
                for(int i = 0 ; i < strNombres.size(); i++){
                    if(strNombres.get(i).equalsIgnoreCase(nombre)){
                        indice = i;
                        break;
                    }
                }

                // actualizar la cantidad de dicho producto.
                if(indice != -1){
                    numCantidades.set(indice, nuevaCantidad);
                } else {
                    System.out.println("producto no encontrado");
                }

                //preguntar al usuario si desae hacer otra actualizacion.
                System.out.println("¿desea actualizar la cantidad de otro producto? responda si o no.");
                strRespuesta3 = scanner.nextLine().trim().toLowerCase();

            }while(strRespuesta3.equals("si"));
        }

        //CALCULAR LOS VALORES TOTALES DE LOS PRODUCTOS
        //variable paar el inventario final.
        double inventario = 0.0d;

        //se crea el array para almacenar el valor total de cada producto incluyento actualizaciones y nuevos productos;
        double[] valoresTotales = new double[strNombres.size()];

        //llenamos el array creado con los valores totales de los productos.
        //se muestra tambien el reporte final de los datos d elos productos incluyendo actualizaciones.
        System.out.println("El reporte final con las actualizaciones y los nuevos productos es : ");
        for(int i = 0 ; i < strNombres.size() ; i++){
            valoresTotales [i] = numCantidades.get(i) * numPrecios.get(i);
            inventario += valoresTotales[i];
            System.out.println("producto : "+strNombres.get(i)+" - Cantidad : "+numCantidades.get(i)+" - Precio por unidad : "+numPrecios.get(i)+" - Valor Total : "+valoresTotales[i]);
        }
        //se muestra el valor total del inventario final.
        System.out.println("el valor total del inventario es de : "+inventario);
        scanner.close();
    }
}