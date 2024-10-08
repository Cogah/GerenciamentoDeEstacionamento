package gradlee;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class GeolocationServiceNominatim {
    private static final String BASE_URL = "https://nominatim.openstreetmap.org/search";

    private OkHttpClient client;

    public GeolocationServiceNominatim() {
        client = new OkHttpClient();
    }

    public void obterCoordenadas(String endereco) {
        
        String url = BASE_URL + "?format=json&q=" + endereco.replace(" ", "%20");

      
        Request request = new Request.Builder()
            .url(url)
            .addHeader("User-Agent", "EstacionamentoApp") 
            .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                System.out.println("Erro na requisição: " + response.message());
                return;
            }

            String jsonResponse = response.body().string();

            if (jsonResponse.contains("[]")) {
                System.out.println("Nenhuma coordenada encontrada para o endereço.");
            } else {
                int latStart = jsonResponse.indexOf("\"lat\":\"") + 7;
                int latEnd = jsonResponse.indexOf("\"", latStart);
                String latitude = jsonResponse.substring(latStart, latEnd);

                int lonStart = jsonResponse.indexOf("\"lon\":\"") + 7;
                int lonEnd = jsonResponse.indexOf("\"", lonStart);
                String longitude = jsonResponse.substring(lonStart, lonEnd);

                System.out.println("Latitude: " + latitude + ", Longitude: " + longitude);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}