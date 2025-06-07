package ejercicio3;

import ejercicio1.ObserverTemperatura;
import ejercicio1.Sujeto;

import java.util.List;

public class MedidorDecorador extends Sujeto implements Lector{

    private Lector medidor;

    public MedidorDecorador(Lector medidor, List<ObserverTemperatura> observadores) {
        super(observadores);
        this.medidor = medidor;
    }

    public String leerTemperatura() {

        var temperatura = this.medidor.leerTemperatura();
        this.notifyObserver(temperatura);
        return temperatura;
    }
}
