package com.tfl.glue;

import com.tfl.api.service.EmployeeService;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.qameta.allure.Step;
import io.restassured.path.json.JsonPath;

import static com.google.common.truth.Truth.assertWithMessage;

public class TflStepDefs {

    private String employee;

    @When("^User request user by id <id>$")
    public void userRequestUserByIdId() throws Throwable {
        EmployeeService service = new EmployeeService();
        employee = service.getEmployeeById(2);
    }

    @Then("^It should be equal to <name> and <last_name>$")
    public void itShouldBeEqualToNameAndLast_name() throws Throwable {
        JsonPath jp = new JsonPath(employee);
        jp.setRootPath("data");
        
    }
}
