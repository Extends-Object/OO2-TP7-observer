package ejercicio4.MODEL;

import java.sql.SQLException;

public interface IApi {

    public void onBotonCargar(String nombre, String telefono, String region, String email) throws SQLException;
}
