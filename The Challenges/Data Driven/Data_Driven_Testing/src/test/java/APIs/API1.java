package APIs;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class API1 {

    String getAllProductEndPoint = "https://automationexercise.com/api/productsList";

    @Test
    public void getAllProductList(){
        Response response = RestAssured.get(getAllProductEndPoint);

        //get status code
        System.out.println(response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(),200);

        // fetch and display all hedders of responce
        //System.out.println(response.getHeaders());

        // fetch specific header value
        System.out.println(response.getHeader("Date"));

        // fetch body context of responce
        //System.out.println(response.asString());
        System.out.println(response.asPrettyString());
    }


}
