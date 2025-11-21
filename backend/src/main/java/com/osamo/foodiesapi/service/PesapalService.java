package com.osamo.foodiesapi.service;

import com.osamo.foodiesapi.entity.OrderEntity;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class PesapalService {

    @Value("${pesapal_key}")
    private String PESAPAL_KEY;

    @Value("${pesapal_secret}")
    private  String PESAPAL_SECRET;

    private String getPesapalToken() {
        String url = "https://cybqa.pesapal.com/pesapalv3/api/Auth/RequestToken";

        JSONObject body = new JSONObject();
        body.put("consumer_key", PESAPAL_KEY);
        body.put("consumer_secret", PESAPAL_SECRET);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request = new HttpEntity<>(body.toString(), headers);

        RestTemplate rest = new RestTemplate();
        ResponseEntity<String> response = rest.postForEntity(url, request, String.class);

        JSONObject json = new JSONObject(response.getBody());
        return json.getString("token");
    }


    private JSONObject submitPesapalOrder(OrderEntity order, String token) {

        String url = "https://cybqa.pesapal.com/pesapalv3/api/Transactions/SubmitOrderRequest";

        JSONObject payload = new JSONObject();
        payload.put("id", order.getId().toString());
        payload.put("currency", "KES");
        payload.put("amount", order.getAmount());
        payload.put("description", "Foodies Order Payment");
        payload.put("callback_url", "https://yourapp.com/payment/callback");
        payload.put("notification_id", "YOUR_NOTIFICATION_ID");

        // Customer details
        JSONObject billing = new JSONObject();
        billing.put("email_address", "customer@example.com");
        billing.put("phone_number", "0712345678");
        billing.put("country_code", "KE");
        payload.put("billing_address", billing);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(token);

        HttpEntity<String> request = new HttpEntity<>(payload.toString(), headers);

        RestTemplate rest = new RestTemplate();
        ResponseEntity<String> response = rest.postForEntity(url, request, String.class);

        return new JSONObject(response.getBody());
    }



}
