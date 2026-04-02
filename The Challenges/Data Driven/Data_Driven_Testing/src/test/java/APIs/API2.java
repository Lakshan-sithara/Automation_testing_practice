package APIs;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class API2 {



    @Test
    public void POSTAllProductList(){
        String postAllProductEndPoint = "https://automationexercise.com/api/productsList";

        Response response = given()
                .header("Content-Type", "application/json")
                .when()
                .post(postAllProductEndPoint)
                .then()
                .extract().response();

        response.prettyPrint();

    }

}
