package ejercicio1;

import ejercicio3.Lector;

public class Medidor implements Lector {
    private String temperatura;
    private ClimaOnline clima;

    public Medidor(ClimaOnline clima) {
        this.clima = clima;
    }

    @Override
    public String leerTemperatura() {

        this.temperatura = this.clima.temperatura();
        //this.notifyObserver(this.temperatura);
        return this.temperatura;
    }
}
