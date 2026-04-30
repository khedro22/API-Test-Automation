package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import models.requestmodels.CreateProductRequest;
import models.responsemodels.ErrorResponseModel;
import models.responsemodels.SingleCategory;

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

    public static SingleCategory getCATegory(int expectedStatusCode, int id){
        return RestHelper.restGet(Constants.BASE_URL, Constants.CATEGORY_END_POINT, "/"+id, SingleCategory.class, expectedStatusCode);
    }
    public static ErrorResponseModel getInvalidCategory(int expectedStatusCode, int id){
        return RestHelper.restGet(Constants.BASE_URL, Constants.CATEGORY_END_POINT, "/"+id, ErrorResponseModel.class, expectedStatusCode);
    }
    public static SingleCategory createCategory(CreateProductRequest requestBody, int expectedStatusCode){
        return RestHelper.restPost(Constants.BASE_URL, Constants.CATEGORY_END_POINT, requestBody, SingleCategory.class, expectedStatusCode);
    }
    public static ErrorResponseModel createInvalidCategory(CreateProductRequest requestBody, int expectedStatusCode){
        return RestHelper.restPost(Constants.BASE_URL, Constants.CATEGORY_END_POINT, requestBody, ErrorResponseModel.class, expectedStatusCode
        );
    }

}
