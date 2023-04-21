package es.ufv.pgpi.itnow.back;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PGL_productosBDD {
    public static List<PGL_producto> cargarDatos() {
        List<PGL_producto> productos = new ArrayList<>();
        String url = "jdbc:sqlite:E:/Tablas/productos.db";

        try (Connection conn = DriverManager.getConnection(url)) {
            System.out.println("Connection to temporary database created successfully.");

            Statement stmt = conn.createStatement();
            String querySql = "SELECT * FROM productos";
            ResultSet rs = stmt.executeQuery(querySql);

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                int existencias = rs.getInt("existencias");
                String ubicacion = rs.getString("ubicacion");
                float precio = rs.getFloat("precio");
                productos.add(new PGL_producto(nombre, existencias, ubicacion, precio));
            }

            rs.close();
            stmt.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return productos;
    }
}
