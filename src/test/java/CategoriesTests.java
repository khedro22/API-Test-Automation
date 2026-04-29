import io.restassured.response.Response;
import models.responsemodels.SingleCategory;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static utils.CategoriesUtilits.*;

public class CategoriesTests {

    // this is test case 1
    @Test
    public void getOneCategory()
    {
        Response response = getCategory("/1");
        response.then().statusCode(200);
        SingleCategory singleCategory = response.as(SingleCategory.class);
        Assert.assertEquals(singleCategory.id, 1, "id is not correct");
    }
    // this test case 2
    @Test
    public void getCategories()
    {
        Response response = getAllCategories();
        Assert.assertEquals(response.statusCode(), 200, "Status is not correct");
        response.prettyPrint();
    }

    @Test
    public void getInvalidCategory()
    {
        Response response = getCategory("/0");
        Assert.assertEquals(response.statusCode(), 400, "Status is not correct");
    }
}
