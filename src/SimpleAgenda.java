import java.util.Scanner;

public class SimpleAgenda {
    private String[] contactos;
    private int nextIndex;

    public SimpleAgenda() {
        contactos = new String[10];
        nextIndex = 0;
    }

    public void agregarContacto() {
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese un contacto a agregar:");
        String nombre = input.nextLine();

        if (contains(nombre)) {
            System.out.println("Ya se ha agregado anteriormente.");
        } else {
            contactos[nextIndex] = nombre;
            nextIndex++;
            System.out.println("Agregado satisfactoriamente.");
        }
    }

    public boolean contains(String nombre) {
        for (String contacto : contactos) {
            if (contacto != null && contacto.equals(nombre)) {
                return true;
            }
        }
        return false;
    }

    public void removerContacto() {
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese un contacto a remover:");
        String nombre = input.nextLine();

        int index = -1;
        for (int i = 0; i < nextIndex; i++) {
            if (contactos[i] != null && contactos[i].equals(nombre)) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            contactos[index] = null;
            System.out.printf("El contacto '%s' fue removido exitosamente!%n", nombre);
        } else {
            System.out.println("No existe tal contacto.");
        }
    }

    public void mostrarContacto() {
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese un contacto a mostrar:");
        String nombre = input.nextLine();

        for (String contacto : contactos) {
            if (contacto != null && contacto.equals(nombre)) {
                System.out.printf("El contacto '%s' existe.%n", nombre);
                return;
            }
        }

        System.out.println("No existen registros de este contacto.");
    }

    public void mostrarContactos() {
        System.out.println("Mostrando contactos...");
        for (String contacto : contactos) {
            if (contacto != null) {
                System.out.println(contacto);
            }
        }
    }

    public static void main(String[] args) {
        SimpleAgenda agenda = new SimpleAgenda();
        agenda.agregarContacto();
        agenda.removerContacto();
        agenda.mostrarContacto();
        agenda.mostrarContactos();
    }
}