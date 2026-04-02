package APIs;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class API6 {

    @Test
    public void postToSearchProductWithoutSearchProductParameter(){
        String searchProductEndpoint = "https://automationexercise.com/api/searchProduct";

        Response response = given()
                .when()
                .post(searchProductEndpoint)
                .then()
                .extract().response();
        response.prettyPrint();
    }

}
