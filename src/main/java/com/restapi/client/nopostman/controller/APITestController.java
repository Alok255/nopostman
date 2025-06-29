package com.restapi.client.nopostman.controller;

import com.restapi.client.nopostman.model.APITestRequest;
import com.restapi.client.nopostman.model.APITestResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Base64;

@RestController
@RequestMapping("/api")
//@Tag(name = "", description = "Test rest api by sending dynamic http requests ")
public class APITestController {


    @PostMapping(path = "/testEndpoint", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Execute REST API request", description = "Privide method, URL, headers, body, auth to dynamically execute HTTP request.")
    public ResponseEntity<APITestResponse> testAPi(@RequestBody APITestRequest request) throws Exception{

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest.Builder builder = HttpRequest.newBuilder()
                .uri(URI.create(request.getUrl()));

        switch (request.getMethod().toUpperCase()){
            case "GET" -> builder.GET();
            case "POST" -> builder.POST(HttpRequest.BodyPublishers.ofString(request.getBody() !=null ? request.getBody() : ""));
            case "PUT" -> builder.PUT(HttpRequest.BodyPublishers.ofString(request.getBody() != null ? request.getBody() : ""));
            case "DELETE" -> builder.DELETE();
            default -> throw new IllegalArgumentException("Unsupported HTTP method: " + request.getMethod());
        }

        if (request.getHeaders() != null){
            request.getHeaders().forEach(builder::header);
        }

        if (request.getAuthType() != null){
            switch (request.getAuthType()){
                case BEARER -> builder.header("Authorization", "Bearer " + request.getToken());
                case BASIC -> {
                    String credentials = request.getUsername() + ":" + request.getPassword();
                    String encoded = Base64.getEncoder().encodeToString(credentials.getBytes());
                    builder.header("Authorization", "Basic" + encoded);
                }
            }
        }

        HttpResponse<String> response = client.send(builder.build(), HttpResponse.BodyHandlers.ofString());
        APITestResponse apiTestResponse= new APITestResponse();
        apiTestResponse.setStatusCode(response.statusCode());
        apiTestResponse.setResponseBody(response.body());
        apiTestResponse.setResponseHeaders(response.headers().map());
        return ResponseEntity.ok(apiTestResponse);
    }
}

