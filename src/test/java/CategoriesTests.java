import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static utils.CategoriesUtilits.*;

public class CategoriesTests {


    @Test
    public void getOneCategory()
    {
        Response response = getCategory("/1");
        response.then().statusCode(200);
    }

    @Test
    public void getCategories()
    {
        Response response = getAllCategories();
        Assert.assertEquals(response.statusCode(), 200, "Status is not correct");
    }

    @Test
    public void getInvalidCategory()
    {
        Response response = getCategory("/0");
        Assert.assertEquals(response.statusCode(), 400, "Status is not correct");
    }
}
