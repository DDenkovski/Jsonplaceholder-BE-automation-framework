package models.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class EmployeeModelResponsePUT {

    String status;
    EmployeeDataPUT data;
    String message;

}
