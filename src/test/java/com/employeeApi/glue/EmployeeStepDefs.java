package com.employeeApi.glue;

import com.employeeApi.api.service.EmployeeService;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.path.json.JsonPath;

import static com.google.common.truth.Truth.assertThat;

public class EmployeeStepDefs {

    private final EmployeeService service = new EmployeeService();

    private JsonPath employee;
    private Integer newEmployeeId;
    private Integer statusCode;

    @When("^User request user by id \"([^\"]*)\"$")
    public void userRequestUserById(Integer id) {
        employee = service.getEmployeeById(id);
    }

    @Then("^It should be equal to \"([^\"]*)\" and \"([^\"]*)\"$")
    public void itShouldBeEqualToAnd(String name, String lastName) {
        employee.setRootPath("data");
        assertThat(name).isEqualTo(employee.get("first_name"));
        assertThat(lastName).isEqualTo(employee.get("last_name"));
    }

    @Then("^It should be sucessfully created and contain \"([^\"]*)\" \"([^\"]*)\" data$")
    public void itShouldBeSucessfullyCreatedAndContainData(String name, String job) throws Throwable {
        assertThat(newEmployeeId).isNotNull();
        employee = service.getEmployeeById(newEmployeeId);
        assertThat(name).isEqualTo(employee.get("first_name"));
        assertThat(job).isEqualTo(employee.get("last_name"));
    }

    @When("^User provides employee data \"([^\"]*)\" \"([^\"]*)\"$")
    public void userProvidesEmployeeData(String name, String job) {
        String requestBody = "{\n" +
                "    \"name\": \"" + name + "\",\n" +
                "    \"job\": \" " + job + "\"\n" +
                "}";
        newEmployeeId = Integer.parseInt(service.createEmployee(requestBody).get("id"));
    }

    @When("^User try to remove user by id \"([^\"]*)\"$")
    public void userTryToRemoveUserById(Integer id) {
        statusCode = service.deleteEmployeeById(id);
    }

    @Then("^Response should return \"([^\"]*)\" status code$")
    public void responseShouldReturnStatusCode(Integer expectedStatusCode){
        assertThat(statusCode).isEqualTo(expectedStatusCode);
    }
}