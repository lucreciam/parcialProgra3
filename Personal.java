package personal;

public class Personal {

    private String legajo;
    private String nombreCompleto;

    //Constructor
    public Personal(String legajo, String nombreCompleto) {
        this.legajo = legajo;
        this.nombreCompleto = nombreCompleto;
    }

    //Getters y Setters
    public String getLegajo() {
        return legajo;
    }

    public void setLegajo(String legajo) {
        this.legajo = legajo;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    //Metodo toString
    @Override
    public String toString() {
        return "Personal" +
                "legajo: '" + getLegajo() + '\'' +
                "nombreCompleto: '" + getNombreCompleto() + '\'';
    }

    //Tuve que agregar el metodo a la super clase porque se me rompia todo usando la interfaz :(
    public void calcularSueldo() {
    }
}
