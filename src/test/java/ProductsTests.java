import io.restassured.response.Response;
import models.responsemodels.ErrorResponseModel;
import models.responsemodels.SingleProduct;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.ProductsUtilits;
import utils.RestHelper;

import java.util.List;
import static utils.ProductsUtilits.getProduct;

public class ProductsTests {
    @Test
    public void getProducts()
    {
        SoftAssert softAssert = new SoftAssert();
        Response response = ProductsUtilits.getAllProducts();
        Assert.assertEquals(response.getStatusCode(), 200, "status code is wrong");//status code is hard assertion because if there is a problem with status code then the problem will be the same to all assertions
        softAssert.assertNotNull(response.jsonPath().getInt("[0].price"), "price is not found"); //soft assertion
        softAssert.assertAll();
        List<SingleProduct> products = response.jsonPath().getList("", SingleProduct.class);
        System.out.println(products.get(0).price);
        response.prettyPrint();
    }

    @Test
    public void getSingleProduct()
    {
        //SoftAssert softAssert = new SoftAssert();
        Response response = getProduct("2");
        response.prettyPrint();
        SingleProduct singleProduct = response.as(SingleProduct.class);
        System.out.println(singleProduct.price);
        System.out.println(singleProduct.title);

    }

     @Test
    public void getInvalidProduct()
    {   Response response = getProduct("0");
        Assert.assertEquals(response.getStatusCode(), 400, "status code is wrong");
        response.prettyPrint();
        ErrorResponseModel errorResponseModel = response.as(ErrorResponseModel.class);
        Assert.assertEquals(errorResponseModel.message, "Product not found", "error message is wrong");
     }

     @Test
    public void getProduct2()
     {

     }
}
