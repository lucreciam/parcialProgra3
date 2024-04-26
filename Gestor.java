import personal.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import personal.Supervisor;
import personal.Administrativo;
import personal.Repartidor;
import personal.Vendedor;

public class Gestor {
    private List<Personal> personal;
    private Scanner scanner;

    public Gestor() {
        this.personal = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public List<Personal> getPersonal() {
        return personal;
    }

    //bsuqueda por legajo
    public Personal buscarPorLegajo(String legajo){
        for(Personal empleado : getPersonal())
        {
            if(Objects.equals(empleado.getLegajo(), legajo))
            {
                return empleado;
            }
        }
        return null;

    }

    //agregar personal segun el tipo que sea
    public void agregarPersonal(Vendedor vendedor) {
        personal.add(vendedor);
    }

    public void agregarPersonal(Administrativo administrativo){
        personal.add(administrativo);

    }

    public void agregarPersonal(Repartidor repartidor){
        personal.add(repartidor);
    }

    public void agregarPersonal(Supervisor supervisor) {
        personal.add(supervisor);
    }

    //metodos para agregar manual un empleado segun el tipo que sea
    public void agregarVendedor() {
        System.out.print("Ingrese el legajo del vendedor: ");
        String legajo = scanner.nextLine();
        System.out.print("Ingrese el nombre completo del vendedor: ");
        String nombreCompleto = scanner.nextLine();
        System.out.print("Ingrese el total de ventas del vendedor: ");
        long totalVentas = scanner.nextLong();
        scanner.nextLine();

        Vendedor vendedor = new Vendedor(legajo, nombreCompleto, totalVentas);
        agregarPersonal(vendedor);
        System.out.println("Vendedor agregado correctamente.");
    }

    public void agregarAdministrador() {
        System.out.print("Ingrese el legajo del administrador: ");
        String legajo = scanner.nextLine();
        System.out.print("Ingrese el nombre completo del administrador: ");
        String nombreCompleto = scanner.nextLine();
        System.out.print("Ingrese el área de administración (VENTAS, LOGISTICA, FINANZAS): ");
        String areaString = scanner.nextLine();
        CategoriaAdmi categoriaAdmi = CategoriaAdmi.valueOf(areaString.toUpperCase());

        Administrativo administrativo = new Administrativo(legajo, nombreCompleto, categoriaAdmi);
        agregarPersonal(administrativo);
        System.out.println("Administrador agregado correctamente.");
    }

    public void agregarRepartidor() {
        System.out.print("Ingrese el legajo del repartidor: ");
        String legajo = scanner.nextLine();
        System.out.print("Ingrese el nombre completo del repartidor: ");
        String nombreCompleto = scanner.nextLine();
        System.out.print("Ingrese la cantidad de kilómetros recorridos del repartidor: ");
        int kilometros = scanner.nextInt();
        scanner.nextLine();

        Repartidor repartidor = new Repartidor(legajo, nombreCompleto, kilometros);
        agregarPersonal(repartidor);
        System.out.println("Repartidor agregado correctamente.");
    }

    public void agregarSupervisor(){
        System.out.print("Ingrese el legajo del supervisor: ");
        String legajo = scanner.nextLine();
        System.out.print("Ingrese el nombre completo del supervisor: ");
        String nombreCompleto = scanner.nextLine();
        scanner.nextLine();

        Supervisor supervisor = new Supervisor(legajo, nombreCompleto);
        agregarPersonal(supervisor);
        System.out.println("Supervisor agregado correctamente.");
    }

    //Metodo para agregar vendedores a la lista del supervisor
    public void agregarVendedorSupervisado (Supervisor supervisor) {
        System.out.print("Ingrese un numero de legajo para buscar vendedor en supervicion ");
        String legajo = scanner.nextLine();
        Vendedor vendedor = (Vendedor) buscarPorLegajo(legajo);
        supervisor.setVendedoresSupervisados(vendedor);

    }

    public void buscarEmpleado() {
        System.out.print("Ingrese el legajo del empleado a buscar: ");
        String legajo = scanner.nextLine();
        Personal empleado = buscarPorLegajo(legajo);
        if (empleado != null) {
            System.out.println("Empleado encontrado:");
            System.out.println(empleado);
        } else {
            System.out.println("Empleado no encontrado.");
        }
    }

    //metodo para llamar en el menu y calcular el sueldo

    public void calcularSueldo() {
        System.out.print("Ingrese el legajo del empleado para calcular su sueldo: ");
        String legajo = scanner.nextLine();
        Personal empleado = buscarPorLegajo(legajo);
        if (empleado != null) {
            empleado.calcularSueldo();
        } else {
            System.out.println("Empleado no encontrado.");
        }
    }


    //muestar de empelados
    public void mostrarEmpleados() {
        System.out.println("Lista de empleados:");
        for (Personal empleado : getPersonal()) {
            //empleado.calcularSueldo();
            System.out.println(empleado);
        }
    }

    //Switch para agregar empelados de diferentes tipos
    public void agregarEmpleado() {
        System.out.println("Agregar nuevo empleado:");
        System.out.print("Ingrese el tipo de empleado (1: Vendedor, 2: Administrador, 3: Repartidor , 4: Supervisor): ");
        int tipoEmpleado = scanner.nextInt();
        scanner.nextLine();

        switch (tipoEmpleado) {
            case 1:
                agregarVendedor();
                break;
            case 2:
                agregarAdministrador();
                break;
            case 3:
                agregarRepartidor();
                break;
            case 4:
                agregarSupervisor();
            default:
                System.out.println("Tipo de empleado no válido.");
                break;
        }
    }

    //metodo que se llama al comienzo del menu para agreagr algunos empleados
    public void cargarEmpleadosRandom() {
        Personal personal1 = new Repartidor("1", "Lucrecia Martin version 1", 300);
        personal.add(personal1);
        Personal personal2 = new Repartidor("2", "Lucrecia Martin version 2", 300);
        personal.add(personal2);
        Personal personal3 = new Administrativo("3", "Lucrecia Martin version 3", CategoriaAdmi.lOGISTICA);
        personal.add(personal3);
        Personal personal4 = new Administrativo("4", "Lucrecia Martin version 4", CategoriaAdmi.FINANZAS);
        personal.add(personal4);
        Personal personal5 = new Administrativo("5", "Lucrecia Martin version 5", CategoriaAdmi.VENTAS);
        personal.add(personal5);
        Personal personal6 = new Supervisor("6", "Lucrecia Martin version 6");
        personal.add(personal6);
        Personal personal7 = new Vendedor("7", "Lucrecia Martin version 7", 300000);
        personal.add(personal7);
        Personal personal8 = new Vendedor("8", "Lucrecia Martin version 8", 600000);
        personal.add(personal8);
        Personal personal9 = new Vendedor("9", "Lucrecia Martin version 9", 1001000);
        personal.add(personal9);

    }



}
