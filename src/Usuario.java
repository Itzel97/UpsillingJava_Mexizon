import javax.sound.sampled.Port;
import java.util.List;

public class Usuario {

    private int ID;
    private String nombreUser;
    private int credito;
    private List<Producto> productosVende;
    private List<Producto> productosCompra;


    // usuario nuevo que no tiene ni historial de compra ni venta
    public Usuario (int ID, String nombreUser,int credito){
        this.ID= ID;
        this.nombreUser= nombreUser;
        this.credito = credito;
    }

 // usuario que compra y vende
   /* public Usuario (int ID, String nombreUser, int credito, List<Producto> productosVende, List<Producto> productosCompra){
        this.ID= ID;
        this.nombreUser= nombreUser;
        this.credito = credito;
        this.productosVende = productosVende;
        this.productosCompra = productosCompra;
    }*/
// usuario que  solo vende


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombreUser() {
        return nombreUser;
    }

    public void setNombreUser(String nombreUser) {
        this.nombreUser = nombreUser;
    }

    public List<Producto> getProductosVende() {
        return productosVende;
    }

    public void setProductosVende(List<Producto> productosVende) {
        this.productosVende = productosVende;
    }

    public List<Producto> getProductosCompra() {
        return productosCompra;
    }

    public void setProductosCompra(List<Producto> productosCompra) {
        this.productosCompra = productosCompra;
    }

    public int getCredito() {
        return credito;
    }

    public void setCredito(int credito) {
        this.credito = credito;
    }

    @Override
    public String toString() {
        return "{" +
                "ID: " + ID +
                ", nombreUser: " + nombreUser + '\'' +
                ", credito: " + credito +
                ", productosVende: " + productosVende +
                ", productosCompra: " + productosCompra +
                '}';
    }
}
