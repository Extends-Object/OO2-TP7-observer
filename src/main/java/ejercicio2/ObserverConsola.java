package ejercicio2;

import ejercicio1.ObserverTemperatura;

public class ObserverConsola implements ObserverTemperatura {

    public static final int TEMPERATURA_FRIA = 12;
    public static final int TEMPERATURA_CALIDA = 17;

    @Override
    public void update(String nuevaTemperatura) {

        double temperatura = Double.parseDouble(nuevaTemperatura.replace(" °C", "").trim());

        if(temperatura < TEMPERATURA_FRIA ){
            System.out.println("Hace frio, se encenderá la caldera");
        }else if (temperatura > TEMPERATURA_CALIDA){
            System.out.println("Hace calor, se encenderá el aire acondicionado");
        } else {
            System.out.println("Temperatura moderada: " + temperatura + "°C");
        }
    }
}
