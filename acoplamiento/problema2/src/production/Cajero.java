package production;

import java.util.ArrayList;

public class Cajero {
    private Inventario inventario;

    public Cajero(Inventario inventario) {
        this.inventario = inventario;
    }

    public void procesarTransaccion(Carrito carrito) {
        System.out.println("El precio total es: " + carrito.getPrecio());
        inventario.actualizarInventario(carrito.getProductos());
    }

    public static void main(String[] args) {
        Inventario inventario = new Inventario();
        Cajero cajero = new Cajero(inventario);

        Producto producto1 = new Producto("Producto 1", 1000);
        Producto producto2 = new Producto("Producto 2", 2000);
        Producto producto3 = new Producto("Producto 3", 3000);

        inventario.addProducto(producto1);
        inventario.addProducto(producto2);
        inventario.addProducto(producto3);

        Carrito carrito = new Carrito();

        carrito.addProducto(producto1);
        carrito.addProducto(producto2);
        cajero.procesarTransaccion(carrito);


    }


}
