public class Producto   {

    private String nombre;
    private int precio;
    private String descripcion;

    private Categoria categoria;

    private Subcategoria subcategoria;

    public Producto(String nombre, int precio, String descripcion, Categoria categoria) {
        this.categoria = categoria;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    public Producto(String nombre, int precio, String descripcion, Categoria categoria, Subcategoria subcategoria) {
        this.categoria = categoria;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.subcategoria = subcategoria;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Subcategoria getSubcategoria() {
        return subcategoria;
    }

    public void setSubcategoria(Subcategoria subcategoria) {
        this.subcategoria = subcategoria;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "{" +
                "nombre: " + nombre + '\'' +
                ", precio: " + precio +
                ", descripcion: " + descripcion + '\'' +
                ", subcategoria: " + subcategoria +
                '}';
    }
}


