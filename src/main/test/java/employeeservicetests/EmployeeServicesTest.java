package employeeservicetests;

import client.EmployeeClient;
import data.EmployeeServiceDataFactoryPOSTPUT;
import io.restassured.response.Response;
import models.request.EmployeeModelRequestPOSTPUT;
import models.response.*;
import org.junit.Test;

import static objectbuilder.EmployeePOSTPUT.createBodyForEmployeesPOSTPUT;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class EmployeeServicesTest {

    @Test
    public void GetAllEmployeesTest(){
        Response getResponse = new EmployeeClient()
                .GETAllEmployees();

        EmployeeModelResponseGETAll employeesResponse = getResponse.body().as(EmployeeModelResponseGETAll.class);

        assertEquals(200, getResponse.statusCode());
        assertEquals("success", employeesResponse.getStatus());
        assertFalse(employeesResponse.getData().isEmpty());
        assertEquals("Successfully! All records has been fetched.", employeesResponse.getMessage());
    }

    @Test
    public void GetEmployeeByIdTest(){
        Response getResponse = new EmployeeClient()
                .GETOneEmployee(3);

        EmployeeModelGETById employeeResponse = getResponse.body().as(EmployeeModelGETById.class);

        assertEquals(200, getResponse.statusCode());
        assertEquals("success", employeeResponse.getStatus());
        assertEquals(3, employeeResponse.getData().getId());
        assertEquals("Ashton Cox", employeeResponse.getData().getEmployee_name());
        assertEquals(86000, employeeResponse.getData().getEmployee_salary());
        assertEquals(66, employeeResponse.getData().getEmployee_age());
        assertEquals("", employeeResponse.getData().getProfile_image());
    }

    @Test
    public void postEmployeeRequestWithDefaultValuesTest(){
        EmployeeModelRequestPOSTPUT requestBody = new EmployeeServiceDataFactoryPOSTPUT(createBodyForEmployeesPOSTPUT())
                .createRequest();

        Response postResponse = new EmployeeClient()
                .POSTEmployee(requestBody);

        EmployeeModelResponsePOST employeeResponse = postResponse.body().as(EmployeeModelResponsePOST.class);

        assertEquals(200, postResponse.statusCode());
        assertEquals("success", employeeResponse.getStatus());
        assertEquals("Default name", employeeResponse.getData().getName());
        assertEquals("Default salary", employeeResponse.getData().getSalary());
        assertEquals("Default age", employeeResponse.getData().getAge());
        assertEquals("Successfully! Record has been added.", employeeResponse.getMessage());
    }

    @Test
    public void postEmployeeRequestWithValuesTest(){
        EmployeeModelRequestPOSTPUT requestBody = new EmployeeServiceDataFactoryPOSTPUT(createBodyForEmployeesPOSTPUT())
                .setName("Denis")
                .setSalary("44000")
                .setAge("25")
                .createRequest();

        Response postResponse = new EmployeeClient()
                .POSTEmployee(requestBody);

        EmployeeModelResponsePOST employeeResponse = postResponse.body().as(EmployeeModelResponsePOST.class);

        assertEquals(200, postResponse.statusCode());
        assertEquals("success", employeeResponse.getStatus());
        assertEquals("Denis", employeeResponse.getData().getName());
        assertEquals("44000", employeeResponse.getData().getSalary());
        assertEquals("25", employeeResponse.getData().getAge());
        assertEquals("Successfully! Record has been added.", employeeResponse.getMessage());
    }

    @Test
    public void updateEmployeeRequestTest(){
        EmployeeModelRequestPOSTPUT requestBody = new EmployeeServiceDataFactoryPOSTPUT(createBodyForEmployeesPOSTPUT())
                .setName("Denis")
                .setSalary("55000")
                .setAge("27")
                .createRequest();

        Response postResponse = new EmployeeClient()
                .PUTEmployee(requestBody, "1");

        EmployeeModelResponsePUT employeeResponse = postResponse.body().as(EmployeeModelResponsePUT.class);
        assertEquals(200, postResponse.statusCode());
        assertEquals("success", employeeResponse.getStatus());
        assertEquals("Denis", employeeResponse.getData().getName());
        assertEquals("55000", employeeResponse.getData().getSalary());
        assertEquals("27", employeeResponse.getData().getAge());
        assertEquals("Successfully! Record has been updated.", employeeResponse.getMessage());
    }

    @Test
    public void DeleteEmployeeTest(){
        String id = "1";

        Response deleteResponse = new EmployeeClient()
                .DELETEEmployee(id);

        EmployeeModelResponseDELETE responseDelete = deleteResponse.body().as(EmployeeModelResponseDELETE.class);

            assertEquals(200, deleteResponse.statusCode());
            assertEquals("success",responseDelete.getStatus());
            assertEquals(id, responseDelete.getData());
            assertEquals("Successfully! Record has been deleted", responseDelete.getMessage());
    }
}