package ejercicio4.DATABASE;


import ejercicio4.MODEL.Participante;
import ejercicio4.MODEL.RegistroParticipante;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcClass implements RegistroParticipante {

//    private String url = "jdbc:derby://localhost:1527/participantes";
//    private String user = "app";
//    private String password = "app";

    @Override
    public void guardar (Participante participante) {

        String sentenciaSQL = "insert into participantes(nombre, telefono, region, email) values(?,?,?,?)";

        try (
                Connection conn = ConnectionManager.getConnection();
                PreparedStatement st = conn.prepareStatement(sentenciaSQL);

        ){

            st.setString(1, participante.getNombre());
            st.setString(2, participante.getTelefono());
            st.setString(3, participante.getRegion());
            st.setString(4, participante.getEmail());

            st.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al procesar la sentencia.");
            throw new RuntimeException("Error en la conexión: ", e);
        } finally {
            ConnectionManager.disconnect();
        }
    }

//    private Connection setupBaseDeDatos() {
//        String url = "jdbc:derby://localhost:1527/participantes";
//        String user = "app";
//        String password = "app";
//
//        try {
//            return DriverManager.getConnection(url, user, password);
//        } catch (SQLException e) {
//            throw new RuntimeException("Error en la conexion", e);
//        }
//    }
}