import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class Cotizaciones {
    static double obtenerValor(String divisa, String jsonResponse){
        Gson gson= new Gson();
        JsonObject jsonObject=gson.fromJson(jsonResponse,JsonObject.class);
        return jsonObject.getAsJsonObject("conversion_rates").get(divisa).getAsDouble();
    }
}
