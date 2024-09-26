import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Convertidor {
    public static void main (String[]args) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/393175bc3f0133b3b281b20f/latest/USD"))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String respuesta = response.body();


        while (true) {
            System.out.println("**********CONVERTIDOR DE DIVISAS***********************");
            System.out.println("1.Covertir dolares a pesos argentinos");
            System.out.println("2.Convertir pesos argentinos a dolares");
            System.out.println("3.Convertir dolares a reales brasilenos");
            System.out.println("4.Convertir reales brasilenos a dolares");
            System.out.println("5.Convertir dolares a peso colombiano");
            System.out.println("6.Convertir peso colombiano a dolares");
            System.out.println("7.Terminar programa");
            System.out.println("*******************************************************");

            System.out.println("Ingresa una opcion");

            Scanner scanner = new Scanner(System.in);
            int opcion = Integer.parseInt(scanner.nextLine());
            String monedas = "";
            String monedaOrigen = "";
            String monedaCambio = "";


            switch (opcion) {
                case 1:
                    monedas = "ARS";
                    monedaOrigen = "dolares americanos";
                    monedaCambio = " pesos argentinos ";
                    break;
                case 2:
                    monedas = "ARS";
                    monedaOrigen = " pesos argentinos ";
                    monedaCambio = " dolares americanos ";
                    break;
                case 3:
                    monedas = "BRL";
                    monedaOrigen = "dolares americanos";
                    monedaCambio = " reales brasilenos ";
                    break;
                case 4:
                    monedas = "BRL";
                    monedaOrigen = " reales brasilenos ";
                    monedaCambio = " dolares americanos ";
                    break;
                case 5:
                    monedas = "COP";
                    monedaOrigen = "dolares americanos";
                    monedaCambio = " pesos colombianos ";
                    break;
                case 6:
                    monedas = "COP";
                    monedaOrigen = " pesos colombianos";
                    monedaCambio = " dolares americanos";
                    break;
                case 7:
                    System.out.println("Programa terminado.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida.");
                    scanner.close();
                    return;
            }

            System.out.println("Ingresa la cantidad a convertir");
            double cantidad = Double.parseDouble(scanner.nextLine());


            var pluma = Cotizaciones.obtenerValor(monedas, respuesta);


            if (monedaOrigen.equals("dolares americanos")) {
                System.out.println("El valor de la  es de " + pluma + " por dolar americano"  + " el total es de " + pluma * cantidad + monedaCambio);
            } else {
                System.out.println("El valor de la moneda es de " + pluma  + monedaOrigen + " por dolar americano, el total es de " + cantidad/pluma + monedaCambio);
            }


        }
    }


}
