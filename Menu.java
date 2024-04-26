import personal.*;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.ArrayList;

public class Menu {
    private Gestor gestor;
    private Scanner scanner;

    public Menu() {
            this.gestor = new Gestor();
            this.scanner = new Scanner(System.in);
    }

        public void iniciar() {

            gestor.cargarEmpleadosRandom();

            int opcion;
            do {
                mostrarMenu();
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        gestor.agregarEmpleado();
                        break;
                    case 2:
                        gestor.buscarEmpleado();
                        break;
                    case 3:
                        gestor.calcularSueldo();
                        break;
                    case 4:
                        gestor.mostrarEmpleados();
                        break;
                    case 5:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                        break;
                }
            } while (opcion != 5);
        }

        private void mostrarMenu() {
            System.out.println("Menú:");
            System.out.println("1. Agregar nuevo empleado");
            System.out.println("2. Buscar empleado por legajo");
            System.out.println("3. Calcular sueldo de empleado especifico");
            System.out.println("4. Mostrar lista de empleados con sueldo calculados");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
        }
}
