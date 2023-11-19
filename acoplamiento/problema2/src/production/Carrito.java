package production;

import java.util.ArrayList;

public class Carrito {
    private ArrayList<Producto> productos = new ArrayList<Producto>();
    private double precio = 0;

    public ArrayList<Producto> getProductos() {
        return new ArrayList<Producto>(productos);
    }

    public void addProducto(Producto producto) {
        this.productos.add(producto);
        this.precio += producto.getPrecio();
    }

    public double getPrecio() {
        return precio;
    }
}
