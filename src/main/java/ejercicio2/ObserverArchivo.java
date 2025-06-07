package ejercicio2;

import ejercicio1.ObserverTemperatura;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

public class ObserverArchivo implements ObserverTemperatura {

    private File archivo;

    public ObserverArchivo(String ruta) {
        this.archivo = new File(ruta);
    }

    @Override
    public void update(String nuevaTemperatura) {

        String registroTemperatura = ("Fecha: " + LocalDate.now() + " || Temperatura: " + nuevaTemperatura);

        try {
            PrintWriter salida = new PrintWriter(new FileWriter(this.archivo, true));
            salida.println(registroTemperatura);
            salida.close();
            System.out.println("Se actualizó el archivo con el nuevo registro de temperatura correctamente.");
        } catch (IOException e) {
            throw new RuntimeException("Error al guardar inscripción en archivo", e);
        }

    }
}
