package data;

import models.request.EmployeeModelRequestPOSTPUT;

public class EmployeeServiceDataFactoryPOSTPUT {

    private EmployeeModelRequestPOSTPUT request;

    public EmployeeServiceDataFactoryPOSTPUT(EmployeeModelRequestPOSTPUT requestBody){
        request = requestBody;
    }

    public EmployeeServiceDataFactoryPOSTPUT setName(String value){
        request.setName(value);
        return this;
    }

    public EmployeeServiceDataFactoryPOSTPUT setSalary(String value){
        request.setSalary(value);
        return this;
    }

    public EmployeeServiceDataFactoryPOSTPUT setAge(String value){
        request.setAge(value);
        return this;
    }

    public EmployeeModelRequestPOSTPUT createRequest(){
        return request;
    }

}
