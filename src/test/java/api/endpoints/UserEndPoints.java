package api.endpoints;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class UserEndPoints {

      public static Response createUser(User user)
       {
        Response response = given()
                   .contentType(ContentType.JSON)
                   .accept(ContentType.JSON)
                   .body(user)
           .when()
                   .post(Routes.post_url);
        return response ;
       }

    public static Response readUser(String  userName)
    {
        Response response =
                given()
                     .pathParam("username",userName)
                .when()
                     .post(Routes.get_url);
        return response ;
    }

    public static Response updateUser(String userName, User payload)
    {
        Response response = given()
                        .accept(ContentType.JSON)
                        .contentType(ContentType.JSON)
                        .pathParam("username",userName)
                        .body(payload)
                        .when()
                       .put(Routes.update_url);


        return response ;
    }

    public static Response deleteUser(String  userName)
    {
        Response response =
                    given()
                        .pathParam("username",userName)
                        .when()
                        .delete(Routes.delete_url);
        return response ;
    }


}
