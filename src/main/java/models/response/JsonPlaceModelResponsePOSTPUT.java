package models.response;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JsonPlaceModelResponsePOSTPUT {

    int id;
    String title;
    String body;
    int userId;
}
