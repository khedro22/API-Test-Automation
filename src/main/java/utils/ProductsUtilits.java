package utils;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ProductsUtilits {
    public static Response getProduct(String id)
    {
        return given()
                .log()
                .all()
                .baseUri(Constants.BASE_URL).when().get(Constants.PRODUCT_END_POINT+"/" + id);
    }
    public static Response getAllProducts()
    {
        return given()
                .log()
                .all()
                .baseUri(Constants.BASE_URL).when().get(Constants.PRODUCT_END_POINT);
    }
}
