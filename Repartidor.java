package personal;

import java.util.Scanner;

public class Repartidor extends Personal implements CalculoSueldo{

    private int kilometros;

    private final long plusPorKilometro = 5000;
    private long sueldo;

    //Constructores
    public Repartidor(String legajo, String nombreCompleto, int kilometros) {
        super(legajo, nombreCompleto);
        this.kilometros = kilometros;
        this.sueldo = SueldoBase.REPARTIDOR; //El sueldo es inicilizado con sueldo base, luego se modificara en caso necesario
    }

    public Repartidor (String legajo, String nombreCompleto){ //Sobreescribo el constructor en el caso de no tener kilometros recorridos
        super(legajo, nombreCompleto);
        this.sueldo = SueldoBase.REPARTIDOR;
        this.kilometros = 0;
    }

    //Getters y Setters
    public int getKilometros() {
        return kilometros;
    }

    public void setKilometros(int kilometros) {
        this.kilometros = kilometros;
    }

    public long getSueldo() {
        return sueldo;
    }

    public void setSueldo(long sueldo) {
        this.sueldo = sueldo;
    }

    //Metodo toString

    @Override
    public String toString() {
        return "Perfil Repartidor " + '\'' +
                "kilometros: " + getKilometros() + '\'' +
                "sueldo: " + "$" + getSueldo();
    }

    //Metodo para calcular sueldo
    public void calcularSueldo() {

        if (kilometros == 0) { //Pido los kilometros en caso de q sean 0 los cargados
            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingrese los kilómetros recorridos por el repartidor " + getNombreCompleto() + ": ");
            kilometros = scanner.nextInt();
            setKilometros(kilometros);
        } else{
            kilometros = getKilometros();
        }
        long sueldo = getSueldo() + ( plusPorKilometro * kilometros); //calculo el nuevo sueldo en base a el plus x km
        setSueldo(sueldo);
        System.out.println("Legajo: " + getLegajo() + '\'' +
                            "Nombre: " + getNombreCompleto() + '\''+
                            "El sueldo del repartidor es: $" + sueldo);
    }


}
