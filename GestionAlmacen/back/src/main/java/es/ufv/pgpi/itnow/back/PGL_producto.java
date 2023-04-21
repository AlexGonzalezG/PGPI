package es.ufv.pgpi.itnow.back;

public class  PGL_producto {

    private String ID;
    private String nombre_producto;
    private int existencias;
    private String ubicacion;
    private float precio;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public PGL_producto(String ID, String nombre_producto, int existencias, String ubicacion, float precio) {
        this.ID = ID;
        this.nombre_producto = nombre_producto;
        this.existencias = existencias;
        this.ubicacion = ubicacion;
        this.precio = precio;
    }

    public PGL_producto() {
    }

    @Override
    public String toString() {
        return "PGL_producto{" +
                "ID='" + ID + '\'' +
                ", nombre_producto='" + nombre_producto + '\'' +
                ", existencias=" + existencias +
                ", ubicacion='" + ubicacion + '\'' +
                ", precio=" + precio +
                '}';
    }
}
