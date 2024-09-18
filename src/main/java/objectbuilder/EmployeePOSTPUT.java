package objectbuilder;

import models.request.EmployeeModelRequestPOSTPUT;

public class EmployeePOSTPUT {

    public static EmployeeModelRequestPOSTPUT createBodyForEmployeesPOSTPUT(){
        return EmployeeModelRequestPOSTPUT.builder()
                .name("Default name")
                .salary("Default salary")
                .age("Default age")
                .build();
    }
}
