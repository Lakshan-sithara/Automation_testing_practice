package APIs;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class API7 {

    @Test
    public void postToLoginWithValidDetails(){
        String loginEndpoint = "https://automationexercise.com/api/verifyLogin";

        HashMap<String,String> loginDetails = new HashMap<>();
        loginDetails.put("email","ac@aa.mm");
        loginDetails.put("password","123");

        Response response = given()
                .formParams(loginDetails)
                .post(loginEndpoint)
                .then()
                .extract().response();
        response.prettyPrint();
    }

}
