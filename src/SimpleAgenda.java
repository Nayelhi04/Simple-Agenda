import java.util.Scanner;

public class SimpleAgenda {
    public static void agregarContacto() {
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese un contacto a agregar:");
        String nombre = input.nextLine();

        if (nombre.length() > 4 && nombre.length() < 8) {
            System.out.println("Contacto agregado con éxito.");
        } else if (nombre.length() >=8 && nombre.length() <= 30) {
            System.out.println("Agregado, contiene entre 8-30 caracteres");
        } else {
            System.out.println("Nombre muy largo");
        }
    }

    public static void removerContacto(int id) {
        if (id >= 1000 && id <= 9999) {
            System.out.println("Verificando contacto a eliminar...");
        } else {
            System.out.println("ID inválido");
        }
    }

    public static String actualizarContacto(int id) {
        return "N/A";
    }

    public static void mostrarContactos() {
        System.out.println("Mostrando contactos...");
    }

    public static void main(String[] args) {
        agregarContacto();
        removerContacto(1234);
        mostrarContactos();
    }
}