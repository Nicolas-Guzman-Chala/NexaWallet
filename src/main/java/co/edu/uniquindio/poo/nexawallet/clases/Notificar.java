package co.edu.uniquindio.poo.nexawallet.clases;

import okhttp3.*;

public class Notificar {

    private final OkHttpClient client;
    private final String apiKey;
    private final String baseUrl;

    public Notificar(String baseUrl, String apiKey) {
        this.client = new OkHttpClient();
        this.apiKey = apiKey;
        this.baseUrl = baseUrl;
    }

    public String enviarSms(String numero, String mensaje) throws Exception {

        String json = "{\n" +
                "  \"messages\": [\n" +
                "    {\n" +
                "      \"from\": \"InfoSMS\",\n" +
                "      \"destinations\": [ { \"to\": \"" + numero + "\" } ],\n" +
                "      \"text\": \"" + mensaje + "\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        RequestBody body = RequestBody.create(
                json,
                MediaType.parse("application/json")
        );

        Request request = new Request.Builder()
                .url(baseUrl + "/sms/2/text/advanced")
                .post(body)
                .addHeader("Authorization", "App " + apiKey)
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }
}