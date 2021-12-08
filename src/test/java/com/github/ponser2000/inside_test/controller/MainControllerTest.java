package com.github.ponser2000.inside_test.controller;

import com.github.ponser2000.inside_test.security.AuthRequest;
import com.github.ponser2000.inside_test.security.AuthResponse;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MainControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void whenGetUserThenCorrect() throws JSONException {

        AuthResponse authResponse = getAuthHeaderForUser("user2", "password2");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", "Bearer " + authResponse.getJwtToken());

        JSONObject userJsonObject = new JSONObject();
        userJsonObject.put("name", "user2");
        userJsonObject.put("message", "history 10");

        ResponseEntity<String> response = restTemplate.exchange("/message", HttpMethod.POST, new HttpEntity<String>(userJsonObject.toString(), headers), String.class);

        assertTrue(response.getBody().equals("[{\"id\":100004,\"dateTime\":\"2021-06-24T08:00:00\",\"message\":\"message1 user2\",\"user_id\":100001}]"));
    }

    private AuthResponse getAuthHeaderForUser(String name, String password) {

        AuthRequest authRequest = new AuthRequest();
        authRequest.setName(name);
        authRequest.setPassword(password);
        AuthResponse authResponse = restTemplate.postForObject("/authenticate", authRequest, AuthResponse.class);

        return authResponse;
    }

}