package ejercicio1;

import java.util.List;

public abstract class Sujeto {

    private List<ObserverTemperatura> listaObservadores;

    protected Sujeto(List<ObserverTemperatura> listaObservadores) {
        this.listaObservadores = listaObservadores;
    }


    public void agregarObservador(ObserverTemperatura observador) {
        listaObservadores.add(observador);
    }

    protected void notifyObserver(String temperatura) {
        for (ObserverTemperatura observador : listaObservadores) {
            observador.update(temperatura);     //push
        }
    }
}

