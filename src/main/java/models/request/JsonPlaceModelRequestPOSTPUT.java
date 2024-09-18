package models.request;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JsonPlaceModelRequestPOSTPUT {

    String title;
    String body;
}
