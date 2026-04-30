package utils;
import io.restassured.common.mapper.TypeRef;
import java.util.Map;
import static io.restassured.RestAssured.given;

public class RestHelper {

    public static <T> T restGet(String URL, String endpoint, String path, Class<T> responseClass, int expectedStatusCode) {
        return given()
                .relaxedHTTPSValidation()
                .when().log().all()
                .get(URL.concat(endpoint).concat(path))
                .then().statusCode(expectedStatusCode).log().all()
                .extract()
                .as(responseClass);
    }

    public static <T> T restGet(String URL, String endpoint, Class<T> responseClass, int expectedStatusCode) {
        return given()
                .relaxedHTTPSValidation()
                .when().log().all()
                .get(URL.concat(endpoint))
                .then().statusCode(expectedStatusCode).log().all()
                .extract()
                .as(responseClass);
    }

    public static <T> T restGet(String URL, String endpoint, TypeRef<T> typeRef, int expectedStatusCode) {
        return given()
                .relaxedHTTPSValidation()
                .when().log().all()
                .get(URL.concat(endpoint))
                .then().statusCode(expectedStatusCode).log().all()
                .extract()
                .as(typeRef);
    }

    public static <T> T restPost(String URL, String endpoint, Object requestBody, Class<T> responseClass, int expectedStatusCode) {
        return given()
                .relaxedHTTPSValidation()
                .contentType("application/json")
                .body(requestBody)
                .when().log().all()
                .post(URL.concat(endpoint))
                .then().statusCode(expectedStatusCode).log().all()
                .extract()
                .as(responseClass);
    }

    public static <T> T restGet(String URL, String endpoint, Map<String, String> headers, Class<T> responseClass, int expectedStatusCode) {
        return given()
                .relaxedHTTPSValidation()
                .contentType("application/json")
                .headers(headers)
                .when().log().all()
                .get(URL.concat(endpoint))
                .then().statusCode(expectedStatusCode).log().all()
                .extract()
                .as(responseClass);
    }

}
