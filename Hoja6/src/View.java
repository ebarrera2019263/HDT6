/**
 * @author Jorge Lopez
 *
 */
import java.util.Scanner;
public class View{
    //Propiedades
    private Scanner scan;

    //Metodos
    public void welcome() {
        System.out.println("Bienvenido a su tienda online !"); // Titulo
        System.out.println("Se esta abriendo su archivo ListadoProducto.txt "); // mensaje
    }
    public View(){
        scan = new Scanner(System.in); // Scanner
    }
    public int menu(){ //Menu
        String salir = "";
        int numMenu = 0;
        String tmpTexto = "";
        boolean isNumeric = false;
        while(!salir.equalsIgnoreCase("si")){
            //Se imprime el menu en pantalla y se le pide al usuario un numero del menu
            System.out.println("\nEscoja el map que desea utilizar: \n");
            System.out.println("1. HashMap");
            System.out.println("2. TreeMap");
            System.out.println("3. LinkedHashMap");
            System.out.println("4. Salir");
            System.out.println("\nPor favor elija una opcion \n");
            tmpTexto = scan.nextLine();

            // Verifica que el numero que dio el usuario sea valido
            isNumeric = tmpTexto.chars().allMatch( Character::isDigit );
            if (isNumeric && !tmpTexto.isEmpty()){
                numMenu = Integer.parseInt(tmpTexto);
                salir = "si";
            }
            while (tmpTexto.isEmpty()||!isNumeric || numMenu < 1 || numMenu > 4) {
                System.out.println("ERROR, ingresar una opcion de menu mayor que 0" + " o menor que 4");
                tmpTexto = scan.nextLine();
                isNumeric = tmpTexto.chars().allMatch( Character::isDigit );
                numMenu = 0;
                if (isNumeric&&!tmpTexto.isEmpty()){
                    numMenu = Integer.parseInt(tmpTexto);
                    salir = "si";
                }
            }
        }
        return numMenu;
    }
    public int menu2(){ //Segundo menu
        String salir = "";
        int numMenu = 0;
        String tmpTexto = "";
        boolean isNumeric = false;
        while(!salir.equalsIgnoreCase("si")){
            //muestra el menu
            System.out.println("\nEscoja el numero de la accion que quiere realizar. \n");
            System.out.println("1. Agregar un productos la coleccion");
            System.out.println("2. Mostrar la categoria del producto");
            System.out.println("3. Mostrar los datos del producto, categoria y cantidad de articulos que hay en la coleccion");
            System.out.println("4. Mostrar los datos del producto, categoria y cantidad de articulos que hay en la coleccion ordenadamente por el tipo");
            System.out.println("5. Mostrar el producto y la categoria de todo el inventario");
            System.out.println("6. Mostrar el producto y la categoria de todo el inventario ordenadamente por el tipo");
            System.out.println("7. Salir");
            System.out.println("\nPor favor elija una opcion! \n");
            tmpTexto = scan.nextLine();

            // Verifica que el numero que dio el usuario fue valido
            isNumeric = tmpTexto.chars().allMatch( Character::isDigit );
            if (isNumeric && !tmpTexto.isEmpty()){
                numMenu = Integer.parseInt(tmpTexto);
                salir = "si";
            }
            while (tmpTexto.isEmpty()||!isNumeric || numMenu < 1 || numMenu > 7) {
                System.out.println("ACCION INVALIDA, ingrese una opcion de menu mayor que 0" + " o menor que 7");
                tmpTexto = scan.nextLine();
                isNumeric = tmpTexto.chars().allMatch( Character::isDigit );
                numMenu = 0;
                if (isNumeric&&!tmpTexto.isEmpty()){
                    numMenu = Integer.parseInt(tmpTexto);
                    salir = "si";
                }
            }
        }
        return numMenu;
    }

    //Al salir del programa
    public void end(){
        System.out.println(" Gracias por utilizar el programa \n"); // Mensaje que se mostrara al salir del programa
        System.exit(0);
        scan.close();
    }
    public void error(String e){
        System.out.println("Ocurrio un error : -- " + e);
    }
    public void output(String mensaje){
        System.out.println(mensaje); //mensaje que se le imprimira al usuario
    }
    //****************************************************************
    public String inputString(String mensaje){
        output(mensaje);
        String dato = scan.nextLine();
        return dato;
    }
    public int inputInt(String mensaje) {
        output(mensaje);
        String dato = scan.nextLine();
        int cant = Integer.parseInt(dato);
        return cant;
    }
}