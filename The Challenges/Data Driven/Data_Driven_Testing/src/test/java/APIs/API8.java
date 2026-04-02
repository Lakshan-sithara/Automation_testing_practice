package APIs;

import base.InitiateDriver;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class API8 extends InitiateDriver {

    @Test
    public void postToVerifyLoginWithoutEmailParameter(){
        String loginEndpoint = "https://automationexercise.com/api/verifyLogin";
        HashMap<String,String> loginDetails = new HashMap<>();
        loginDetails.put("password","123");

        Response response = given()
                .formParams(loginDetails)
                .when()
                .post(loginEndpoint)
                .then()
                .extract().response();

        response.body().prettyPrint();
        validateErrorResponce(response);
    }

    public void validateErrorResponce(Response response){
        // 1. Extract the raw string from the RestAssured response
        String rawBodyText = response.body().asString();

        // 2. Clean the string by removing the HTML tags to expose the JSON
        // Using replaceAll with a regex to remove any HTML tags like <html>, <body>, etc.
        // Also handling any invisible characters or HTML entities that might be causing parsing issues
        String jsonText = rawBodyText.replaceAll("<[^>]*>", "").trim();
        // Sometimes HTML includes entities like &nbsp; which need to be cleaned up
        jsonText = jsonText.replace("&nbsp;", "").trim();

        // Ensure the string actually starts with '{' to prevent JSONException
        if (jsonText.contains("{")) {
            jsonText = jsonText.substring(jsonText.indexOf('{'), jsonText.lastIndexOf('}') + 1);
        }

        // 3. Instantiate a JSON object from the cleaned string
        JSONObject responseData = new JSONObject(jsonText);

        System.out.println(jsonText);

        // 4. Extract specific nodes for strict validation
        int actualResponseCode = responseData.getInt("responseCode");
        String actualMessage = responseData.getString("message");

        // 5. Execute strict assertions
        Assert.assertEquals(actualResponseCode, 400, "Expected a 400 Bad Request status code.");
        Assert.assertEquals(actualMessage, "Bad request, email or password parameter is missing in POST request.", "Error message payload did not match the expected specification.");
    }

}
