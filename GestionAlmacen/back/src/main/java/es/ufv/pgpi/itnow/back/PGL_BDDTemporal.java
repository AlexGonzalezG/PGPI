package es.ufv.pgpi.itnow.back;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PGL_BDDTemporal {
    public static void BDD(){
        String url = "jdbc:sqlite:E:/Tablas/productos.db";

        try (Connection conn = DriverManager.getConnection(url)) {
            System.out.println("Connection to temporary database created successfully.");

            // Comprobar si la tabla ya existe
            String tableName = "productos";
            DatabaseMetaData dbm = conn.getMetaData();
            ResultSet tables = dbm.getTables(null, null, tableName, null);
            boolean tableExists = tables.next();
            tables.close();

            if (!tableExists) {
                // Creamos una base de datos temporal para tener algunos datos que manejar
                Statement stmt = conn.createStatement();
                String createTableSql = "CREATE TABLE productos (id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, existencias INTEGER, ubicacion TEXT, precio REAL)";
                stmt.executeUpdate(createTableSql);
                stmt.close();

                // Añadimos valores a la BDD
                List<PGL_producto> productos = new ArrayList<>();
                productos.add(new PGL_producto("Crema Hidratante", 40, "AG3", 8.50f));
                productos.add(new PGL_producto("Maquillaje", 80, "DF4", 13.0f));
                productos.add(new PGL_producto("Pasta de dientes", 120, "BA7", 3.20f));
                productos.add(new PGL_producto("Rimel", 67, "BB5", 17.90f));
                productos.add(new PGL_producto("Pinta Uñas", 70, "PU4", 27.00f));


                String insertSql = "INSERT INTO productos (nombre, existencias, ubicacion, precio) VALUES (?, ?, ?, ?)";
                PreparedStatement pstmt = conn.prepareStatement(insertSql);
                for (PGL_producto producto : productos) {
                    pstmt.setString(1, producto.getNombre_producto());
                    pstmt.setInt(2, producto.getExistencias());
                    pstmt.setString(3, producto.getUbicacion());
                    pstmt.setFloat(4, producto.getPrecio());
                    pstmt.executeUpdate();
                }
                pstmt.close();
            }

            String selectSql = "SELECT * FROM productos";
            Statement selectStmt = conn.createStatement();
            ResultSet rs = selectStmt.executeQuery(selectSql);

            while (rs.next()) {
                System.out.println(rs.getInt("id") + "\t" +
                        rs.getString("nombre") + "\t" +
                        rs.getInt("existencias") + "\t" +
                        rs.getString("ubicacion") + "\t" +
                        rs.getFloat("precio"));
            }

            rs.close();
            selectStmt.close();
            } catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }

