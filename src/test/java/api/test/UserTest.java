package api.test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class UserTest {

    Faker faker;
    User userPayload;

    List<User> users;

    @BeforeClass
    public void setUpData()
    {
    faker = new Faker();
    userPayload = new User();
    users = new ArrayList<>();

    userPayload.setId(faker.idNumber().hashCode());
    userPayload.setUsername(faker.name().username());
    userPayload.setFirstName(faker.name().firstName());
    userPayload.setLastName(faker.name().lastName());
    userPayload.setEmail(faker.internet().emailAddress());
    userPayload.setPassword(faker.internet().password());
    userPayload.setPhone(faker.phoneNumber().cellPhone());

    users.add(userPayload);

    }


    @Test(priority = 1)
    public void testPostUser()
    {
        Response response= UserEndPoints.createUser(users);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);

    }

    @Test(priority = 2)
    public void testGetUserByName()
    {
        Response response = UserEndPoints.readUser(this.userPayload.getUsername());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
    }

    @Test(priority = 3)
    public void testUpdateUserByName()
    {
        userPayload.setFirstName(faker.name().firstName());
        userPayload.setLastName(faker.name().lastName());
        userPayload.setEmail(faker.internet().emailAddress());

        Response response = UserEndPoints.updateUser(this.userPayload.getUsername(),userPayload);
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),200);

        Response responseAfterUpdate = UserEndPoints.readUser(this.userPayload.getUsername());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);

    }

    @Test(priority = 4)
    public void testDeleteUser()
    {
       Response response = UserEndPoints.deleteUser(this.userPayload.getUsername());
       response.then().log().all();
       Assert.assertEquals(response.getStatusCode(),200);
    }



}


