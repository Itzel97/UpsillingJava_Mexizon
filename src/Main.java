import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Categoria

        Categoria tecnologia = new Categoria("tecnologia");
        Categoria mascotas = new Categoria("mascotas");

        Subcategoria audio = new Subcategoria("Audio");
        Subcategoria accesorios = new Subcategoria("Accesorios");


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



        //---- listas de compra y venta------

        List<Producto> productosVentaShiro= new ArrayList<>();
        productosVentaShiro.add(audifonos);
        productosVentaShiro.add(tripieCelular);

        List <Producto> productosCompraShiro = new ArrayList<>();
        productosCompraShiro.add(microfonos);

        List <Producto> productosVentaItzel = new ArrayList<>();
        productosVentaItzel.add(arenaGato);


        List <Producto> productosCompraItzel = new ArrayList<>();
        productosCompraItzel.add(microfonos);

        //------Usuarios--------------------------

       // Usuario itzel = new Usuario(1,"itzelAlonso", 1500,productosVentaItzel,productosCompraItzel);
        //Usuario kevin = new Usuario(2,"Shirocolossus", 4500, productosVentaShiro,productosCompraShiro);



        System.out.println("------Bienvenido a Mexizon--------------");

        System.out.println("Los productos que tenemos a la venta son: ");

        System.out.println(audifonos.toString());
        System.out.println(microfonos.toString());
        System.out.println(tripieCelular.toString());
        System.out.println(arenaGato.toString());

        System.out.println("Usuarios-----------------------------------------------------------------------------------");

       // System.out.println(itzel.toString());
        //System.out.println(kevin.toString());

        System.out.println("----------COMPRAR------------");



    }
}