package ejercicio1;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.JSONObject; //Para parsear JSON (librería)

public class OpenWeatherMapService implements ClimaOnline {

    private String apiKey;
    private String ciudad;

    public OpenWeatherMapService(String apiKey, String ciudad) {
        this.apiKey = apiKey;
        this.ciudad = ciudad;
    }

    @Override
    public String temperatura() {

        //Arma la página con la ciudad y la key
        String url = "https://api.openweathermap.org/data/2.5/weather?q=" + ciudad + "&units=metric&APPID=" + apiKey;

        //q: ciudad
        //units=metric: para temperatura Celsius
        //appid: clave API

        HttpClient client = HttpClient.newHttpClient();                                 //Crea cliente HTTP para hacer la solicitud
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();    //Construye el request HTTP con la URL

        try {

            //Envía solicitud y espera respuesta como texto plano (String)
            HttpResponse<String> respuesta = client.send(request, HttpResponse.BodyHandlers.ofString());

            String body = respuesta.body();

            //Parsea el body de la respuesta (que esta en formato JSON) usando JSONObject
            JSONObject json = new JSONObject(body);
            double temp = json.getJSONObject("main").getDouble("temp");
            //Va al objeto "main" dentro del JSON - De ese main extrae el valor de "temp" como double
            //Esta como algo asi:
            //"main": {
            //  "temp": 22.6
            //}

            return temp + " °C";

        } catch (IOException | InterruptedException e) {
            return "Error al obtener la temperatura";
        }
    }
}