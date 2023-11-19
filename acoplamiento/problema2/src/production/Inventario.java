package production;


// import hashmap
import java.util.ArrayList;
import java.util.HashMap;

public class Inventario {
    private HashMap<String, Producto> producto = new HashMap<String, Producto>();

    public void actualizarInventario(ArrayList<Producto> productos) {
        for (Producto producto : productos) {
            this.producto.remove(producto.getNombre());
        }
    }

    public void addProducto(Producto producto) {
        this.producto.put(producto.getNombre(), producto);
    }
}
