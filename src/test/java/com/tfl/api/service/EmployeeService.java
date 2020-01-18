package com.tfl.api.service;


import com.tfl.api.model.Data;
import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static io.restassured.path.json.JsonPath.from;

public class EmployeeService {

    private static final String URL = "https://reqres.in";

    public String getEmployeeById(Integer id) {
        String json = RestAssured.given()
                .accept("application/json")
                .contentType("application/json")
                .when()
                .get(URL + "/api/users/{id}")
                .then()
                .statusCode(200).extract().asString();

        return json;
}
