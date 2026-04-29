package utils;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class CategoriesUtilits {
    public static Response getCategory(String id)
    {
        return given()
                .log()
                .all()
                .baseUri(Constants.BASE_URL).when().get(Constants.CATEGORY_END_POINT +"/"+ id);
    }
    public static Response getAllCategories()
    {
        return given()
                .log()
                .all()
                .baseUri(Constants.BASE_URL).when().get(Constants.CATEGORY_END_POINT);
    }
}
