package jsonplaceholderapitests;

import client.JsonPlaceClient;
import data.JsonPlaceDataFactoryPOSTPUT;
import io.restassured.response.Response;

import models.request.JsonPlaceModelRequestPOSTPUT;
import models.response.JsonPlaceModelResponseGET;
import models.response.JsonPlaceModelResponsePOSTPUT;

import org.junit.Test;
import java.util.List;

import static objectbuilder.JsonPlacePOSTPUT.createBodyForJsonPlacePUT;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class JsonPlaceholderTests {

    @Test
    public void postsPUTDefaultValuesTest() {
        JsonPlaceModelRequestPOSTPUT requestBody = new JsonPlaceDataFactoryPOSTPUT(createBodyForJsonPlacePUT())
                .createRequests();

        Response putResponse = new JsonPlaceClient()
                .postsPUT(requestBody, "1");

        JsonPlaceModelResponsePOSTPUT response = putResponse.body().as(JsonPlaceModelResponsePOSTPUT.class);

        assertEquals(200, putResponse.statusCode());
        assertEquals("Default title", response.getTitle());
        assertEquals("Default body", response.getBody());
    }

    @Test
    public void postsPUTTest() {
        JsonPlaceModelRequestPOSTPUT requestBody = new JsonPlaceDataFactoryPOSTPUT(createBodyForJsonPlacePUT())
                .setTitle("Updated title")
                .setBody("Updated body")
                .createRequests();

        Response putResponse = new JsonPlaceClient()
                .postsPUT(requestBody, "1");

        JsonPlaceModelResponsePOSTPUT response = putResponse.body().as(JsonPlaceModelResponsePOSTPUT.class);

        assertEquals(200, putResponse.statusCode());
        assertEquals("Updated title", response.getTitle());
        assertEquals("Updated body", response.getBody());
    }

    @Test
    public void postsPOSTDefaultValuesTest() {
        JsonPlaceModelRequestPOSTPUT requestBody = new JsonPlaceDataFactoryPOSTPUT(createBodyForJsonPlacePUT())
                .createRequests();

        Response postResponse = new JsonPlaceClient()
                .postsPOST(requestBody);

        JsonPlaceModelResponsePOSTPUT response = postResponse.body().as(JsonPlaceModelResponsePOSTPUT.class);

        assertEquals(201, postResponse.statusCode());
        assertEquals("Default title", response.getTitle());
        assertEquals("Default body", response.getBody());
    }

    @Test
    public void postsPOSTTest() {
        JsonPlaceModelRequestPOSTPUT requestBody = new JsonPlaceDataFactoryPOSTPUT(createBodyForJsonPlacePUT())
                .setTitle("New title")
                .setBody("New body")
                .createRequests();

        Response putResponse = new JsonPlaceClient()
                .postsPOST(requestBody);

        JsonPlaceModelResponsePOSTPUT response = putResponse.body().as(JsonPlaceModelResponsePOSTPUT.class);

        assertEquals(201, putResponse.statusCode());
        assertEquals("New title", response.getTitle());
        assertEquals("New body", response.getBody());
    }

    @Test
    public void getAllPostsTest(){
        Response getResponse = new JsonPlaceClient()
                .GETAllPosts();

        List<JsonPlaceModelResponseGET> postsResponse = getResponse
                .getBody()
                .jsonPath()
                .getList("", JsonPlaceModelResponseGET.class);

        assertEquals(200, getResponse.statusCode());
        assertFalse(postsResponse.isEmpty());
    }

    @Test
    public void getPostTest(){
        String titleId = "sunt aut facere repellat provident occaecati excepturi optio reprehenderit";
        String bodyId = "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto";

        Response getResponse = new JsonPlaceClient()
                .GETPost("1");
        JsonPlaceModelResponseGET getResponseObject = getResponse.body().as(JsonPlaceModelResponseGET.class);

        assertEquals(200, getResponse.statusCode());
        assertEquals(titleId, getResponseObject.getTitle());
        assertEquals(bodyId, getResponseObject.getBody());
    }

    @Test
    public void deletePostTest(){
        Response deleteResponse = new JsonPlaceClient()
                .DELETEPost("1");

        assertEquals(200, deleteResponse.statusCode());
    }
}