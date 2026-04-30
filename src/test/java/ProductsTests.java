import models.requestmodels.CreateProductRequest;
import models.responsemodels.ErrorResponseModel;
import models.responsemodels.SingleProduct;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.util.List;
import java.util.Random;

import static utils.ProductsUtils.*;


public class ProductsTests {
    Random rand = new Random();

    @Test
    public void getProductsTest(){
        SoftAssert softAssert = new SoftAssert();
        List<SingleProduct> getProductsResponseModel = getProductsList(200);
        softAssert.assertEquals(getProductsResponseModel.get(0).price,20,"Price is not correct");
        softAssert.assertTrue(getProductsResponseModel.get(0).category.name.contains("Clothes"), "description is not correct");
        softAssert.assertAll();
    }

    @Test
    public void getSingleProductTest(){
        SoftAssert softAssert = new SoftAssert();
        SingleProduct getProductsResponseModel = getSingleProduct(200,221);
        softAssert.assertEquals(getProductsResponseModel.price,94,"Price is not correct");
        softAssert.assertTrue(getProductsResponseModel.category.name.contains("Clothes"), "description is not correct");
        softAssert.assertAll();
    }

    @Test
    public void getSingleInvalidProductTest(){
        SoftAssert softAssert = new SoftAssert();
        ErrorResponseModel errorResponseModel = getSingleInvalidProduct(400,0);
        softAssert.assertEquals(errorResponseModel.name, "EntityNotFoundError", "invalid error message" );
        softAssert.assertAll();
    }

    @Test
    public void createProductTest(){
        SoftAssert softAssert = new SoftAssert();
        CreateProductRequest createProductRequest = new CreateProductRequest();
        createProductRequest.setTitle("test product");
        createProductRequest.setPrice(100);
        createProductRequest.setCategoryId(1);
        createProductRequest.setDescription("test description");
        createProductRequest.setImages(List.of("https://placeimg.com/640/480/any"));
        SingleProduct getProductsResponseModel = createProduct(createProductRequest, 201);
        softAssert.assertEquals(getProductsResponseModel.title, "test product", "title is not correct");
        softAssert.assertEquals(getProductsResponseModel.price, 100, "price is not correct");
        softAssert.assertAll();
    }
    @Test
    public void getProductAfterCreation()
    {
        CreateProductRequest createProductRequest = new CreateProductRequest();
        createProductRequest.setTitle("test-product"+rand.nextInt(1000));
        createProductRequest.setPrice(100);
        createProductRequest.setCategoryId(1);
        createProductRequest.setDescription("test description");
        createProductRequest.setImages(List.of("https://placeimg.com/640/480/any"));
        SingleProduct createdProduct = createProduct(createProductRequest, 201);
        int id = createdProduct.id;
        SingleProduct productCreated = getSingleProduct(200, id);
    }

    @Test
    public void createProductWithInvalidCategory()
    {
        CreateProductRequest createProductRequest = new CreateProductRequest();
        createProductRequest.setTitle("test-product"+rand.nextInt(1000));
        createProductRequest.setPrice(100);
        createProductRequest.setCategoryId(0);
        createProductRequest.setDescription("test description");
        createProductRequest.setImages(List.of("https://placeimg.com/640/480/any"));
        ErrorResponseModel error = createProductInvalid(createProductRequest, 400);
    }

    @Test
    public void createProductWithMissingTitle()
    {
        CreateProductRequest createProductRequest = new CreateProductRequest();
        createProductRequest.setPrice(100);
        createProductRequest.setCategoryId(1);
        createProductRequest.setDescription("test description");
        createProductRequest.setImages(List.of("https://placeimg.com/640/480/any"));
        ErrorResponseModel error = createProductInvalid(createProductRequest, 500);
    }

    @Test
    public void createProductWithMissingPrice()
    {
        CreateProductRequest createProductRequest = new CreateProductRequest();
        createProductRequest.setTitle("test-product"+rand.nextInt(1000));
        createProductRequest.setCategoryId(1);
        createProductRequest.setDescription("test description");
        createProductRequest.setImages(List.of("https://placeimg.com/640/480/any"));
        ErrorResponseModel error = createProductInvalid(createProductRequest, 400);}
    @Test
    public void createProductWithMissingCategoryId()
    {
        CreateProductRequest createProductRequest = new CreateProductRequest();
        createProductRequest.setTitle("test-product"+rand.nextInt(1000));
        createProductRequest.setPrice(100);
        createProductRequest.setDescription("test description");
        createProductRequest.setImages(List.of("https://placeimg.com/640/480/any"));
        ErrorResponseModel error = createProductInvalid(createProductRequest, 400);
    }

    @Test
    public void createProductWithMissingDescription()
    {
        CreateProductRequest createProductRequest = new CreateProductRequest();
        createProductRequest.setTitle("test-product"+rand.nextInt(1000));
        createProductRequest.setPrice(100);
        createProductRequest.setCategoryId(1);
        createProductRequest.setImages(List.of("https://placeimg.com/640/480/any"));
        ErrorResponseModel error = createProductInvalid(createProductRequest, 500);
    }
    @Test
    public void createProductWithMissingImages()
    {   CreateProductRequest createProductRequest = new CreateProductRequest();
        createProductRequest.setTitle("test-product"+rand.nextInt(1000));
        createProductRequest.setPrice(100);
        createProductRequest.setCategoryId(1);
        createProductRequest.setDescription("test description");
        ErrorResponseModel error = createProductInvalid(createProductRequest, 400);}


}
