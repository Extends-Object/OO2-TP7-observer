package ejercicio4.MODEL;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.util.Properties;

public class NotificadorEmail implements ObserverParticipante {

    final String username = "d84e36c103e3f5";
    final String password = "4cec2de3b26f70";
    String host = "sandbox.smtp.mailtrap.io";

    private String emisor = "your.recipient@email.com";
    private String asunto = "Inscripción a concurso";
    private String cuerpo = "Usted se ha inscripto exitosamente";


    @Override
    public void enviarEmail(Participante participante) {
        this.notificar(participante);
        System.out.println("Notificando a " + participante.getEmail() + ": Usted se ha inscrito exitosamente.");
    }


    private void notificar(Participante participante) {

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "false");            // Desactivando startTLS porque no reconoce el certificado del servidor de Mailtrap cuando intenta usar startTLS
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "25");                          //Cambiando 587 por 25 --> puerto sin TLS


        Session session = Session.getInstance(props,                //Hace una instancia de la sesion con las prop configuradas
                new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(emisor));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(participante.getEmail()));
            message.setSubject(asunto);
            message.setText(cuerpo);

            Transport.send(message);
            System.out.println("El mensaje se envió correctamente");

        } catch (MessagingException e) {  //Por si falla el envio
            throw new RuntimeException("No se pudo enviar el mensaje", e);
        }
    }
}