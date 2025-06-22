package ejercicio4.Main;

import ejercicio4.DATABASE.JdbcClass;
import ejercicio4.MODEL.DefaultApi;
import ejercicio4.MODEL.IApi;
import ejercicio4.MODEL.NotificadorEmail;
import ejercicio4.MODEL.RegistroParticipante;
import ejercicio4.UI.AgregarParticipanteVista;

import java.awt.*;
import java.sql.SQLException;


public class Main {

    public static void main(String[] args) throws SQLException {


        RegistroParticipante registroParticipante = new JdbcClass();
        var api = new DefaultApi(registroParticipante);

        api.agregarObservador(new NotificadorEmail());

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new AgregarParticipanteVista(api);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });
    }
}