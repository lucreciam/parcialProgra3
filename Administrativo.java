package personal;

public class Administrativo extends Personal{ //extiende de personal

    private CategoriaAdmi categoriaAdmi; //atributo del tipo enum CategoriaAdmi
    private long sueldo;

    //Constructor
    public Administrativo(String legajo, String nombreCompleto, CategoriaAdmi categoriaAdmi) {
        super(legajo, nombreCompleto);
        this.categoriaAdmi = categoriaAdmi;
        this.sueldo = SueldoBase.ADMINISTRATIVO;

    }

    //Getters y Setters
    public CategoriaAdmi getCategoriaAdmi() {
        return categoriaAdmi;
    }

    public void setCategoriaAdmi(CategoriaAdmi categoriaAdmi) {
        this.categoriaAdmi = categoriaAdmi;
    }

    public long getSueldo() {
        return sueldo;
    }

    //metodo toString
    @Override
    public String toString() {
        return "Perfil: Administrativo" +
                "Categoria Administrativa: " + getCategoriaAdmi() +
                "Sueldo " + "$"  +  getSueldo();
    }


}
