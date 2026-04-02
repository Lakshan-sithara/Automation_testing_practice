package APIs;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class API5 {

    @Test
    public void postToSearchProduct(){
        String searchProductEndpoint = "https://automationexercise.com/api/searchProduct";

        Response response = given()
                .formParam("search_product","tshirt")
                .when()
                .post(searchProductEndpoint)
                .then()
                .extract().response();

        response.prettyPrint();

    }

}
