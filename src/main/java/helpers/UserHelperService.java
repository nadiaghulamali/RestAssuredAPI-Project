package helpers;

import constants.EndPoints;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import com.fasterxml.jackson.core.type.TypeReference;
import model.User;
import org.apache.http.HttpStatus;
import utils.ConfigManager;


import java.lang.reflect.Type;
import java.util.List;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class UserHelperService {
    private static final String BASE_URL = ConfigManager.getInstance().getString("baseUrl");

    public UserHelperService() {
        RestAssured.baseURI = BASE_URL;
        RestAssured.useRelaxedHTTPSValidation();
    }

    public List<User> getAllUsers(){
        Response response =
        given().log().all()
                .contentType(ContentType.JSON)
        .when()
                .get(EndPoints.GET_ALL_USERS)
        .andReturn();
        Type type = new TypeReference<List<User>>(){}.getType();
        return response.as(type);
    }

    public Response createUser(){

        User user = new User();
        user.setName("rayle lilly");
        user.setPhone("+1 34567887878");
        user.setEmail("lilly@gmail.com");

        Response response =
                given().log().all()
                        .contentType(ContentType.JSON)
                .when()
                        .body(user)
                        .post(EndPoints.CREATE_USER)
                        .andReturn();

        if (response.getStatusCode() != HttpStatus.SC_CREATED) {
            fail("User creation failed with status code: " + response.getStatusCode());
        }
        return response;
    }

    public Response updateUser(Integer id){

        User user = new User();
        user.setId(6);
        user.setName("rayler lum");
        user.setPhone("+1 34567887878");
        user.setEmail("lilly@gmail.com");

        Response response =
                given().log().all()
                        .contentType(ContentType.JSON)
                .when()
                        .pathParam("Id", id)
                        .body(user)
                        .patch(EndPoints.UPDATE_USER)
                        .andReturn();
        String responseBody = response.getBody().asString();
        System.out.println("Response Body: " + responseBody);
        if (response.getStatusCode() != HttpStatus.SC_OK) {
            fail("User UPDATE failed with status code: " + response.getStatusCode());
        }
        return response;
    }

    public int deleteUser(Integer id){

        User user = new User();
        user.setName("rayle lilly");
        user.setPhone("+1 34567887878");
        user.setEmail("lilly@gmail.com");

        Response response =
                given().log().all()
                        .contentType(ContentType.JSON)
                        .when()
                        .pathParam("Id", id)
                        .body(user)
                        .delete(EndPoints.DELETE_USER)
                        .andReturn();

        return response.getStatusCode();
    }
}
