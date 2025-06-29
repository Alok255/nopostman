# Postman Clone API - Spring Boot

This is a lightweight, open-source REST client built using **Spring Boot**. It mimics the core functionality of Postman via a Swagger UI, allowing users to dynamically test REST APIs with different HTTP methods, headers, body, and authentication types.

## 🚀 Tech Stack
- **Java 17**
- **Spring Boot 3.2.0**
- **Spring Web**
- **Springdoc OpenAPI (Swagger UI)**
- **Java HttpClient (JDK 11+)**
- **Lombok**

---

## 🔧 How It Works
You send a single POST request to `/api/test`, which accepts the desired method, URL, headers, body, and authentication. The server makes the request on your behalf and returns the response.

### Swagger UI
You can use the built-in Swagger UI to test the API:  
📍 `http://localhost:8080/swagger-ui.html`

---

## 📬 Example Request Payloads (RequestBody for /api/test)

### 1. 🔍 GET Request (No Auth)
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

### 2. 📝 POST Request with JSON Body (No Auth)
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

### 3. ✏️ PUT Request
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

### 4. ❌ DELETE Request
```json
{
  "method": "DELETE",
  "url": "https://httpbin.org/delete",
  "authType": "NONE"
}
```

---

## 🔐 Auth Type Scenarios

### 1. ✅ Bearer Token Auth (e.g. GoRest API)
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

### 2. 🔑 Basic Auth (e.g. httpbin.org)
```json
{
  "method": "GET",
  "url": "https://httpbin.org/basic-auth/user/pass",
  "authType": "BASIC",
  "username": "user",
  "password": "pass"
}
```

### 3. 🔐 Generate JWT Token (Example)
Most public APIs now require an API key. Instead of `reqres.in`, you can use a reliable, open endpoint from **https://jwt.io/** or mock one locally.

Here's how you can generate a mock JWT token from an open mock endpoint:

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
You can then copy this `token` into the Bearer Auth request example.json
{
"method": "POST",
"url": "https://reqres.in/api/login",
"headers": {
"Content-Type": "application/json"
},
"body": "{\"email\": \"eve.holt@reqres.in\", \"password\": \"cityslicka\"}",
"authType": "NONE"
}
```
**Expected Response:**
```json
{
  "token": "QpwL5tke4Pnpja7X4"
}
```
You can then use this token in Bearer auth scenarios.

---

## 📦 How to Run
```bash
git clone https://github.com/your-repo/postman-clone-springboot.git
cd postman-clone-springboot
./mvnw spring-boot:run
```

Swagger UI: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

---

## ✅ Future Enhancements
- UI interface (React/Thymeleaf)
- Request history and caching
- Token management interface
- Error log and retry support

---

## 🤝 Contribution
PRs are welcome! For major changes, please open an issue first to discuss what you would like to change.

---

## 📄 License
[MIT](LICENSE)
