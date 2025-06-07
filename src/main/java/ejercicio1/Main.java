package ejercicio1;

import ejercicio2.ObserverArchivo;
import ejercicio2.ObserverConsola;
import ejercicio3.MedidorDecorador;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ClimaOnline clima = new OpenWeatherMapService("843416072f88f479c8626589138ecfcb", "Viedma,AR");

        List<ObserverTemperatura> listaObservadores = new ArrayList<>();

        //Sujeto medidor = new Medidor(clima, listaObservadores);
        var medidor = new MedidorDecorador(new Medidor(clima), listaObservadores);

        medidor.agregarObservador(new ConcreteObserver());
        medidor.agregarObservador(new ObserverConsola());
        medidor.agregarObservador(new ObserverArchivo("src/Temperaturas"));

        medidor.leerTemperatura();  //aca ya imprime


        //String temperaturaActual = medidor.leerTemperatura();
        //System.out.println("Temperatura actual: " + temperaturaActual);
    }
}