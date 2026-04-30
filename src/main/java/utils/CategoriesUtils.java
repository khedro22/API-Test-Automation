package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CategoriesUtils {
    public static Response getAllCategories(){
        return RestAssured.given().log().all().
                get(Constants.BASE_URL + Constants.CATEGORY_END_POINT).
                then().extract().response();
    }

    public static Response getSingleCategory(int id){
        return RestAssured.given().log().all().
                get(Constants.BASE_URL + Constants.CATEGORY_END_POINT + "/" + id).
                then().extract().response();
    }

}
