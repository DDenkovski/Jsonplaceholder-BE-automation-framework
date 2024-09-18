package data;

import models.request.JsonPlaceModelRequestPOSTPUT;

public class JsonPlaceDataFactoryPOSTPUT {

    private JsonPlaceModelRequestPOSTPUT request;

    public JsonPlaceDataFactoryPOSTPUT(JsonPlaceModelRequestPOSTPUT requestBody){
        request = requestBody;
    }

    public JsonPlaceDataFactoryPOSTPUT setTitle(String value){
        request.setTitle(value);
        return this;
    }

    public JsonPlaceDataFactoryPOSTPUT setBody(String value){
        request.setBody(value);
        return this;
    }

    public JsonPlaceModelRequestPOSTPUT createRequests(){
        return request;
    }

}
