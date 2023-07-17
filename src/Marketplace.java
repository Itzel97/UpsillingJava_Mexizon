import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

interface FuncionProductoBusqueda {
    List<Producto> search(List<Producto>  productos, String busqueda);

}

public class Marketplace {
      static List<Usuario> listaUsuarios = new ArrayList<>() ;
      static List<Producto> productosAlaVenta = new ArrayList<>();
     // static  List<Producto> productosVenta = new ArrayList<>();

    //private Usuario usuario;
    //private Producto producto;



     public static void main (String [] args){
         // Categoria------------------------------------------------------------------------
         Categoria tecnologia = new Categoria("tecnologia");
         Categoria mascotas = new Categoria("mascotas");

         Subcategoria audio = new Subcategoria("audio");
         Subcategoria accesorios = new Subcategoria("accesorios");

         //PRODUCTOS-------------------------------------------------------------
         Producto audifonos = new Producto("Razer Kraken Ultimate", 1999,
                 "Garantiza una claridad absoluta a la hora de transmitir la información a tu equipo, con un micrófono altamente afinado que elimina eficazmente los ruidos de fondo, como los del ventilador, el aire acondicionado y el equipo"
                 ,tecnologia,audio);
         Producto microfonos = new Producto("Hisemy micronofo inalambrico",489,
                 "El micrófono de solapa inalámbrico utiliza tecnología de sincronización automática en tiempo real, que reduce en gran medida la posedición de video y le brinda a usted y a sus seguidores una mejor experiencia al ver videos. Con micrófono omnidireccional y tecnología profesional de reducción de ruido, " +
                         "identificación efectiva del sonido original, grabación clara en entornos ruidosos", tecnologia,audio);

         Producto tripieCelular = new Producto("PHOCAR Tripie para celular", 429,"Tripie para Celular y Cámara: el trípode está hecho de una aleación de aluminio liviana y duradera, equipado con un soporte universal para teléfono inteligente, un control remoto inalámbrico y una bolsa de transporte."
                 ,tecnologia,accesorios);

         Producto arenaGato = new Producto("Fancy Pets Arena", 112,"Alto nivel de aglutinamiento que concentra los olores y atrapa la pis de manera inmediata"
                 ,mascotas);


         Usuario itzel = new Usuario(1,"itzelAlonso", 1500);
         Usuario kevin = new Usuario(2,"Shirocolossus", 4500);

         //----------Agregar usuarios
         agregarUsuario(itzel);
         agregarUsuario(kevin);

         //-----------Agragar producto que venden---------
         System.out.println("****************AGREGAR PRODUCTO A LA VENTA ************************");
         agregarProductosAlaVenta(itzel,audifonos);
         agregarProductosAlaVenta(itzel,arenaGato);
         agregarProductosAlaVenta(kevin,microfonos);
         agregarProductosAlaVenta(kevin,tripieCelular);


         //------------comprar productos-----------
         comprarProducto(kevin,audifonos);
         comprarProducto(kevin,arenaGato);
         comprarProducto(itzel,microfonos);

         //--------------Consulta historial de compra----------
         System.out.println("*************** Consulta de historial de productos **************");
         consultarHistorialDeCompra(itzel);

         //--Busqueda de productos----------------------
         FuncionProductoBusqueda categoria = (productos,busqueda) -> {
             System.out.println("buscando por categoria...");
             List <Producto> producto = productos.stream()
                     .filter(p -> p.getCategoria().getNombre().equals(busqueda))
                     .collect(Collectors.toList());
            return producto;
         };

         //buscar por subcategoria
         FuncionProductoBusqueda subCategoria = (productos,busqueda) -> {
             System.out.println("buscando por subcategoria...");
             return productos.stream()
                     .filter(p -> p.getSubcategoria() !=null ? p.getSubcategoria().getNombre().equals(busqueda) : false)
                     .collect(Collectors.toList());
         };

         //buscar por subcategoria
         FuncionProductoBusqueda precio = (productos,busqueda) -> {

             System.out.println("buscando por precio...");
             return
                     productos.stream()
                     .filter(p -> (p.getPrecio() == Integer.parseInt(busqueda)))
                     .collect(Collectors.toList());
         };

         //----LLamando lambdas de busqueda----------------------------------------

         busquedaProductos(productosAlaVenta,"tecnologia",categoria);
         busquedaProductos(productosAlaVenta,"accesorios",subCategoria);
         busquedaProductos(productosAlaVenta,"112",precio);



     }

     public static void busquedaProductos (List<Producto> productosAlaVenta, String busqueda,FuncionProductoBusqueda funcion ) {

          List<Producto> productos = funcion.search(productosAlaVenta,busqueda);
          System.out.println(productos);

     }

    public static void agregarUsuario(Usuario usuario) {
        System.out.println("Se agrego al usuario: " + usuario.getNombreUser());

        listaUsuarios.add(usuario);
    }
    public static List<Usuario> getListaUsuario() {
        return listaUsuarios;
    }

    public static void agregarProductosAlaVenta (Usuario usuario, Producto producto){

        List<Producto> productosVenta = new ArrayList<>();

        if (usuario.getProductosVende() != null){
            productosVenta = usuario.getProductosVende();
        }

        productosVenta.add(producto);
        productosAlaVenta.add(producto);
        usuario.setProductosVende(productosVenta);
        System.out.println(producto);
     }

     public static void consultarHistorialDeCompra (Usuario usuario){
         if(usuario.getProductosCompra() != null){
             System.out.println("No tiene ninguna producto comprado");
         }

         System.out.println("Productos comprados: " + usuario.getProductosCompra());
     }


    public static void comprarProducto(Usuario usuario, Producto producto){

        System.out.println("****************** Ticket de compra **************************");

        List<Producto> productosCompra = new ArrayList<>();

         if (usuario.getCredito() < producto.getPrecio()){
             System.out.println("No tiene suficiente credito");
         }

         int sobranteCredito = usuario.getCredito() - producto.getPrecio();
         usuario.setCredito(sobranteCredito);

         if(usuario.getProductosCompra() != null){
             productosCompra = usuario.getProductosCompra();
         }

        productosCompra.add(producto);
        usuario.setProductosCompra(productosCompra);

        System.out.println("Gracias por tu compra !!! " + usuario.getNombreUser());
        System.out.println("Producto: " + producto.getNombre() + " ,por un costo de: $" + producto.getPrecio());
        System.out.println("Tu credito restante es de: $" + usuario.getCredito());
        System.out.println("--------------------------------------------------");

    }





}
