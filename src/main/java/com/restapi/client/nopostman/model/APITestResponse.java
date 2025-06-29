package com.restapi.client.nopostman.model;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class APITestResponse {

    private int statusCode;
    private String responseBody;
    private Map<String, List<String>> responseHeaders;
}
