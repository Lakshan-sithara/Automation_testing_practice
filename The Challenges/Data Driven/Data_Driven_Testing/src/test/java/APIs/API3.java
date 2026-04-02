package APIs;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class API3 {

    String brandsEndPoint = "https://automationexercise.com/api/brandsList";

    @Test
    public void getAllBrandList(){
        Response brandsResponce = RestAssured.get(brandsEndPoint);
        System.out.println(brandsResponce.getStatusCode());
        System.out.println(brandsResponce.asString());
    }

}
