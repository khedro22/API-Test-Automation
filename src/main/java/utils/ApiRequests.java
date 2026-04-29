package utils;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ApiRequests {
    //get all products
    public static Response get(String endPoint)
    {
        return given()
                .log()
                .all()
                .baseUri(Constants.BASE_URL).when().get(endPoint);
    }
        //get one product
    public static Response get(String endPoint, String id)
    {
        return given()
                .log()
                .all()
                .baseUri(Constants.BASE_URL).when().get(endPoint + "/" + id);
    }
}
