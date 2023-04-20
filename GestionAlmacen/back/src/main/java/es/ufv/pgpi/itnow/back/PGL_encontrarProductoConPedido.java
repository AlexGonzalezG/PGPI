package es.ufv.pgpi.itnow.back;

public class PGL_encontrarProductoConPedido {
    public static void pedidoEncontrado(String nombre){
        PGL_producto producto = new PGL_producto();
        producto.setID("D34");
        producto.setNombre_producto("Crema");
        producto.setExistencias(40);
        producto.setUbicacion("A14");
        producto.setPrecio(40);

        String nomprod = producto.getNombre_producto();
        if (nomprod == nombre){

        }



    }




}

