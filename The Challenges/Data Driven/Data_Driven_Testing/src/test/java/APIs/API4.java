package APIs;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

import static io.restassured.path.json.JsonPath.given;

public class API4 {

    @Test
    public void putToAllBrandsList(){

        String brandsEndPoint = "https://automationexercise.com/api/brandsList";

        Response response = given()
                .header("Content-Type", "application/json")
                // .body("{\"name\": \"New Brand Name\"}") // Optional: add body if required
                .when()
                .put(brandsEndPoint)
                .then()
                .extract().response();

        // Log the response to see what happened
        response.prettyPrint();

    }

}

