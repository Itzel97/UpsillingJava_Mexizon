public class Subcategoria {

    private String nombre;


    public Subcategoria(  String nombreSubcategoria) {

        this.nombre = nombreSubcategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    @Override
    public String toString() {
        return nombre;
    }
}
