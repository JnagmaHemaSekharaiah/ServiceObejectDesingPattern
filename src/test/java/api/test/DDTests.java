package api.test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class DDTests {

    @Test(priority =1, dataProvider="Data", dataProviderClass = DataProviders.class)
    public void testPostUser(String userId, String username,String firstname,String lastname
       , String email, String password,String phone )
    {
        User user = new User();
        user.setId(Integer.parseInt(userId));
        user.setUsername(username);
        user.setFirstName(firstname);
        user.setLastName(lastname);
        user.setEmail(email);
        user.setPassword(password);
        user.setPhone(phone);
        List<User> users = new ArrayList<>();
        users.add(user);

        Response response = UserEndPoints.createUser(users);
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),200);

    }

    @Test(priority = 2,dataProvider="UserName",dataProviderClass=DataProviders.class)
    public void testDeleteUser(String username)
    {

        Response response = UserEndPoints.deleteUser(username);

        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),200);

    }



}
