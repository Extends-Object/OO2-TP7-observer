package ejercicio4.MODEL;

import java.sql.SQLException;

public class DefaultApi extends Subject implements IApi {

    private RegistroParticipante persistencia;

    public DefaultApi(RegistroParticipante persistencia) {
        this.persistencia = persistencia;
    }

    @Override
    public void onBotonCargar(String nombre, String telefono, String region, String email) throws SQLException {
        Participante participante = new Participante(nombre, telefono, region, email);
        this.persistencia.guardar(participante);
        notificarObservadores(participante);
    }
}
