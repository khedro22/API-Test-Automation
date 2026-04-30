package utils;

import models.requestmodels.CreateProductRequest;
import models.responsemodels.ErrorResponseModel;
import models.responsemodels.SingleProduct;
import io.restassured.common.mapper.TypeRef;
import utils.Constants;
import utils.RestHelper;

import java.util.List;

public class ProductsUtils {
    public static SingleProduct getSingleProduct(int expectedStatusCode, int id){
        return RestHelper.restGet(Constants.BASE_URL,Constants.PRODUCT_END_POINT, "/"+id, SingleProduct.class, expectedStatusCode);
    }


    public static ErrorResponseModel getSingleInvalidProduct(int expectedStatusCode, int id){
        return RestHelper.restGet(Constants.BASE_URL, Constants.PRODUCT_END_POINT, "/"+id, ErrorResponseModel.class, expectedStatusCode);
    }

    public static List<SingleProduct> getProductsList(int expectedStatusCode){
        return RestHelper.restGet(Constants.BASE_URL, Constants.PRODUCT_END_POINT, new TypeRef<>() {},expectedStatusCode);
    }

    public static SingleProduct createProduct(CreateProductRequest requestBody, int expectedStatusCode){
        return RestHelper.restPost(Constants.BASE_URL, Constants.PRODUCT_END_POINT, requestBody, SingleProduct.class, expectedStatusCode);
    }
    public static ErrorResponseModel createProductInvalid(CreateProductRequest requestBody, int expectedStatusCode){
        return RestHelper.restPost(Constants.BASE_URL, Constants.PRODUCT_END_POINT, requestBody, ErrorResponseModel.class, expectedStatusCode
        );
    }


}
