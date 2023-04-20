package es.ufv.pgpi.itnow.back;

public class PGL_pedido {
    private String ID_pedido;
    private String nombre_producto;
    private int cantidad;

    public String getID_pedido() {
        return ID_pedido;
    }

    public void setID_pedido(String ID_pedido) {
        this.ID_pedido = ID_pedido;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
