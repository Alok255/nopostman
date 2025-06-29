package com.restapi.client.nopostman.model;

import com.restapi.client.nopostman.enums.AuthType;
import lombok.Data;

import java.util.Map;

@Data
public class APITestRequest {

    private String method;
    private String url;
    private Map<String, String> headers;
    private String body;
    private AuthType authType;
    private String token;
    private String username;
    private String password;
}
