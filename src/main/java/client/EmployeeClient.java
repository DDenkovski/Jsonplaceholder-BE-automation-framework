package client;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.request.EmployeeModelRequestPOSTPUT;
import utils.ConfigurationEmployeeService;

public class EmployeeClient {

    public Response GETAllEmployees() {
        return RestAssured
                .given()
                .when().log().all()
                .get(ConfigurationEmployeeService.EMPLOYEE_GET_ALL)
                .thenReturn();
    }

    public Response GETOneEmployee(int id) {
        return RestAssured
                .given()
                .when().log().all()
                .get(ConfigurationEmployeeService.EMPLOYEE_GET_BY_ID + "/" + id)
                .thenReturn();
    }

    public Response POSTEmployee(EmployeeModelRequestPOSTPUT request) {
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .when().log().all()
                .body(request)
                .post(ConfigurationEmployeeService.EMPLOYEE_POST)
                .thenReturn();
    }

    public Response PUTEmployee(EmployeeModelRequestPOSTPUT request, String id) {
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .when().log().all()
                .body(request)
                .put(ConfigurationEmployeeService.EMPLOYEE_UPDATE + "/" + id)
                .thenReturn();
    }

    public Response DELETEEmployee(String id) {
        return RestAssured
                .given()
                .when().log().all()
                .delete(ConfigurationEmployeeService.EMPLOYEE_DELETE + "/" + id)
                .thenReturn();
    }
}

