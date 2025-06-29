# API Test Console – Spring Boot

**API Test Console** is a lightweight, developer-focused REST client built using **Spring Boot**. It enables dynamic testing of REST APIs directly from a Swagger UI interface, offering support for all HTTP methods, custom headers, request payloads, and various authentication mechanisms.

## Technology Stack
- Java 17
- Spring Boot 3.2.0
- Spring Web
- Java HttpClient (JDK 11+)
- Springdoc OpenAPI (Swagger UI)
- Lombok

---

## Overview
This tool accepts a single POST request to the `/api/test` endpoint, encapsulating the target HTTP method, request URL, headers, body, and authentication parameters. The backend performs the HTTP request on your behalf and returns the full response, including status, headers, and body.

### Swagger UI
Test the functionality through an interactive Swagger interface:  
 `http://localhost:8080/swagger-ui.html`

---

## Usage Examples
The following examples demonstrate how to structure the JSON payload when sending a request to `/api/test`.

### GET Request (No Authentication)
```json
{
  "method": "GET",
  "url": "https://jsonplaceholder.typicode.com/posts/1",
  "headers": {
    "Accept": "application/json"
  },
  "authType": "NONE"
}
```

### POST Request with JSON Payload
```json
{
  "method": "POST",
  "url": "https://httpbin.org/post",
  "headers": {
    "Content-Type": "application/json"
  },
  "body": "{\"name\": \"Alok\", \"role\": \"developer\"}",
  "authType": "NONE"
}
```

### PUT Request
```json
{
  "method": "PUT",
  "url": "https://httpbin.org/put",
  "headers": {
    "Content-Type": "application/json"
  },
  "body": "{\"status\": \"updated\"}",
  "authType": "NONE"
}
```

### DELETE Request
```json
{
  "method": "DELETE",
  "url": "https://httpbin.org/delete",
  "authType": "NONE"
}
```

---

## Authentication Scenarios

### Bearer Token Authentication (GoRest API Example)
```json
{
  "method": "GET",
  "url": "https://gorest.co.in/public/v2/users",
  "headers": {
    "Accept": "application/json"
  },
  "authType": "BEARER",
  "token": "YOUR_ACCESS_TOKEN_HERE"
}
```

### Basic Authentication (httpbin.org Example)
```json
{
  "method": "GET",
  "url": "https://httpbin.org/basic-auth/user/pass",
  "authType": "BASIC",
  "username": "user",
  "password": "pass"
}
```

### JWT Token Generation Example (dummyjson.com)
```json
{
  "method": "POST",
  "url": "https://dummyjson.com/auth/login",
  "headers": {
    "Content-Type": "application/json"
  },
  "body": "{\"username\": \"kminchelle\", \"password\": \"0lelplR\"}",
  "authType": "NONE"
}
```
**Expected Response:**
```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
}
```
You can use this token in Bearer-authenticated requests.

---

## Getting Started
```bash
git clone https://github.com/your-repo/api-test-console.git
cd api-test-console
gradlew clean build
gradlew spring-boot:run
```
Access Swagger UI at: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

---

## Roadmap
- Web-based UI interface (React/Thymeleaf)
- Request history and reusability
- JWT decoding and management
- Error log tracking and retry mechanism

---

## Contributing
Contributions are welcome! Please submit a pull request or open an issue to propose improvements or features.

---

## License
Distributed under the [MIT License](LICENSE).
