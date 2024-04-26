package personal;

import java.util.Scanner;

public class Vendedor extends Personal implements CalculoSueldo{

    private long sueldo;
    private long ventas;

    //Constructor
    public Vendedor(String legajo, String nombreCompleto, long ventas) {
        super(legajo, nombreCompleto);
        this.sueldo = SueldoBase.VENDEDORES;
        this.ventas = ventas;
    }

    public Vendedor(String legajo, String nombreCompleto) {
        super(legajo, nombreCompleto);
        this.sueldo = SueldoBase.VENDEDORES;
        this.ventas = 0;
    }

    //getters y setters
    public long getSueldo() {
        return sueldo;
    }

    public void setSueldo(long sueldo) {
        this.sueldo = sueldo;
    }

    public long getVentas() {
        return ventas;
    }

    public void setVentas(long ventas) {
        this.ventas = ventas;
    }

    //Metodo toString
    @Override
    public String toString() {
        return "Perfil: Vendedor" +
                "sueldo: $" + getSueldo() +
                "ventas: " + getVentas();
    }

    //Metodo que devuelve la comision correspondiete segun el total de ventas
    public float comisionPorVentas (long ventas) //Depende el valor recibido por parametro devuelve el % correspondiente
    {
        if(ventas <= 500000){return 0.1F;}
        else if (ventas < 1000000){ return 0.15F;}
        else if(ventas > 1000000) { return 0.2F;}

        return 0;
    }

    //Calculo de sueldo
    public void calcularSueldo(){

        if(ventas == 0) //pido las ventas en el caso que sean 0
        {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingrese las ventas totales del vendedor " + getNombreCompleto() + ": ");
            ventas = scanner.nextLong();
        }else {
            ventas = getVentas();
        }
        float comision = comisionPorVentas(ventas); //calculo la comision
        long sueldoFinal;
        sueldoFinal = (long) ((long) sueldo + (comision * ventas)); //calculo el sueldo
        setSueldo(sueldoFinal);
        System.out.println("Legajo: " + getLegajo() + '\'' +
                            "Nombre: " + getNombreCompleto() + '\''+
                            "El sueldo del repartidor es: $" + sueldo);
    }


}
