import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SimpleAgenda {
    public SimpleAgenda() {
        String[] contactos = new String[10];
        int nextIndex = 0;
    }

    public static void agregarContacto() {
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese un contacto a agregar:");
        String nombre = input.nextLine();

        if (nombre.length() > 4 && nombre.length() < 8) {
            System.out.println("Contacto agregado con éxito.");
        } else if (nombre.length() >= 8 && nombre.length() <= 30) {
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

    public static String actualizarContacto() {
        return actualizarContacto(0);
    }

    public static String actualizarContacto(int id) {
        return "N/A";
    }

    public static void mostrarContactos() {
        System.out.println("Mostrando contactos...");
        try {
            File file = new File("contactos.txt");
            Scanner scanner = new Scanner(file);
// Saltar la primera línea que contiene los encabezados
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void mostrarContacto() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese nombre a consultar:");
        String nombre = scanner.nextLine();
        try {
            File file = new File("contactos.txt");
            Scanner fileScanner = new Scanner(file);
            boolean encontrado = false;
// Saltar la primera línea que contiene los encabezados
            if (fileScanner.hasNextLine()) {
                fileScanner.nextLine();
            }
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] partes = line.split(",");
                if (partes[0].equals(nombre)) {
                    System.out.println("El contacto " + nombre + " existe.");
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                System.out.println("No existen registros de este contacto.");
            }
            fileScanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void generarArchivo() {
        try {
            File archivo = new File("contactos.txt");
            archivo.createNewFile();
            FileWriter escritor = new FileWriter(archivo);
            escritor.write("contacto,telefono\n" +
                    "Adan,8098551212\n" +
                    "Enmanuel,8294118787\n" +
                    "Raider,8097410032\n" +
                    "Roger,8095554141\n");
            escritor.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        agregarContacto();
        removerContacto(1234);
        mostrarContactos();
        mostrarContacto();
        generarArchivo(); // Agregado para crear el archivo
    }
}