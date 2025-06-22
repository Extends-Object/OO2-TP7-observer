package ejercicio4.MODEL;

import java.util.ArrayList;
import java.util.List;

abstract class Subject {

    private List<ObserverParticipante> observadores = new ArrayList<>();

    public void agregarObservador(ObserverParticipante observador) {
        observadores.add(observador);
    }

    public void eliminarObservador(ObserverParticipante observador) {
        observadores.remove(observador);
    }

    public void notificarObservadores(Participante participante) {
        for (ObserverParticipante observador : observadores) {
            observador.enviarEmail(participante);
        }
    }
}
