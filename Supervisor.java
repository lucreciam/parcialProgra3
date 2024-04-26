package personal;

import java.util.ArrayList;
import java.util.List;

public class Supervisor extends Personal implements CalculoSueldo{

    private long sueldo;
    private List<Vendedor> vendedoresSupervisados; //lista de los vendedores supervisados

    private final float comision = 0.03F; //comision fija (final)

    //Constructor
    public Supervisor(String legajo, String nombreCompleto) {
        super(legajo, nombreCompleto);
        this.sueldo = SueldoBase.SUPERVISOR;
        this.vendedoresSupervisados = new ArrayList<>();
    }

    //getters y setters
    public long getSueldo() {
        return sueldo;
    }

    public void setSueldo(long sueldo) {
        this.sueldo = sueldo;
    }

    public List<Vendedor> getVendedoresSupervisados() {
        return vendedoresSupervisados;
    }

    public void setVendedoresSupervisados(Vendedor vendedor) {
        vendedoresSupervisados.add(vendedor);
    }

    //Metodo toString
    @Override
    public String toString() {
        return "Supervisor{" +
                "sueldo=" + getSueldo() ;
    }

    //Metodo para calcular el total de ventas realizadas por todos los vendedores a cargo
    public long totalVentasDeSupervisados()
    {
        long totalVentas = 0;
            for (Vendedor vendedor : getVendedoresSupervisados()) {
                totalVentas += vendedor.getVentas();
            }

        return totalVentas;
    }

    //Calcular sueldo
    public void calcularSueldo ()
    {
        sueldo += (long) (totalVentasDeSupervisados() * comision); //total de ventas por el atributo fijo de comision
        setSueldo(sueldo);
        System.out.println("Legajo: " + getLegajo() + '\'' +
                            "Nombre: " + getNombreCompleto() + '\''+
                            "El sueldo del Supervisor es: $" + sueldo);

    }





}
