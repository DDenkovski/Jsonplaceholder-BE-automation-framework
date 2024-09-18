package client;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.request.JsonPlaceModelRequestPOSTPUT;
import utils.ConfigurationJsonPlaceholder;

public class JsonPlaceClient {

    public Response postsPUT(JsonPlaceModelRequestPOSTPUT request, String id) {
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .when().log().all()
                .body(request)
                .put(ConfigurationJsonPlaceholder.BASE_URL_JSONPLACE + "/" + id)
                .thenReturn();
    }

    public Response postsPOST(JsonPlaceModelRequestPOSTPUT request) {
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .when().log().all()
                .body(request)
                .post(ConfigurationJsonPlaceholder.BASE_URL_JSONPLACE)
                .thenReturn();
    }

    public Response GETAllPosts() {
        return RestAssured
                .given()
                .when().log().all()
                .get(ConfigurationJsonPlaceholder.BASE_URL_JSONPLACE)
                .thenReturn();
    }

    public Response GETPost(String id) {
        return RestAssured
                .given()
                .when().log().all()
                .get(ConfigurationJsonPlaceholder.BASE_URL_JSONPLACE + "/" + id)
                .thenReturn();
    }

    public Response DELETEPost(String id) {
        return RestAssured
                .given()
                .when().log().all()
                .delete(ConfigurationJsonPlaceholder.BASE_URL_JSONPLACE + "/" + id)
                .thenReturn();
    }
}
