package com.tfl.api.service;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;


public class EmployeeService {

    public EmployeeService() {
        RestAssured request = new RestAssured();
        request.baseURI = "https://reqres.in";
    }

    public JsonPath getEmployeeById(Integer id) {
        JsonPath jsonResponse = given()
                .accept("application/json")
                .contentType("application/json")
                .when()
                .get("/api/users/" + id)
                .then()
                .statusCode(200).extract().jsonPath();
        return jsonResponse;
    }

    public JsonPath createEmployee(String requestBody) {
        JsonPath jsonResponse = given()
                .urlEncodingEnabled(true)
                .body(requestBody)
                .header("Accept", ContentType.JSON.getAcceptHeader())
                .post("/api/users")
                .then()
                .statusCode(201).extract().jsonPath();
        return jsonResponse;
    }

    public Integer deleteEmployeeById(Integer id) {
        return given()
                .header("Content-Type", "application/json")
                .delete("/api/users/" + id).getStatusCode();
    }
}
