package objectbuilder;

import models.request.JsonPlaceModelRequestPOSTPUT;

public class JsonPlacePOSTPUT {

    public static JsonPlaceModelRequestPOSTPUT createBodyForJsonPlacePUT(){
        return JsonPlaceModelRequestPOSTPUT.builder()
                .title("Default title")
                .body("Default body")
                .build();
    }
}
