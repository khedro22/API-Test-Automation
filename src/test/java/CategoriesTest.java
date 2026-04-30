import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static utils.CategoriesUtils.getAllCategories;
import static utils.CategoriesUtils.getSingleCategory;

public class CategoriesTest {

    @Test
    public void getAllCategoriesTest(){
        Response response = getAllCategories();
        response.prettyPrint();
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test
    public void getSingleCategoryTest(){
        Response response = getSingleCategory(1);
        response.prettyPrint();
        Assert.assertEquals(response.statusCode(),200);
    }

    @Test
    public void getSingleCategoryInvalid(){
        Response response = getSingleCategory(0);
        response.prettyPrint();
        Assert.assertEquals(response.statusCode(),400);
    }
}
