package ejercicio1;

public class ConcreteObserver implements ObserverTemperatura{

    @Override
    public void update(String nuevaTemperatura) {
        System.out.println("Temperatura actual: " + nuevaTemperatura);
    }
}
