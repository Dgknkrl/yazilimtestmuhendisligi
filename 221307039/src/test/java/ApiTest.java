
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.concurrent.TimeUnit;

public class ApiTest {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";

    @Test
    public void testGetRequest() {
        long startTime = System.currentTimeMillis();
        System.out.println("\n========== GET TEST BAŞLADI ==========");

        Response response = given()
                .baseUri(BASE_URL)
                .when()
                .get("/posts/1")
                .then()
                .time(lessThan(1500L), TimeUnit.MILLISECONDS)
                .statusCode(200)
                .body("userId", equalTo(1))
                .body("id", equalTo(1))
                .extract().response();

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        System.out.println("GET İstek URL: " + BASE_URL + "/posts/1");
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());
        System.out.println("Çalışma Süresi: " + duration + " ms");
        System.out.println("=== GET TEST TAMAMLANDI ===\n");
    }

    @Test
    public void testPostRequest() {
        long startTime = System.currentTimeMillis();

        System.out.println("\n========== POST TEST BAŞLADI ==========");

        String requestBody = "{\n" +
                "  \"title\": \"Test Post\",\n" +
                "  \"body\": \"Bu bir test içeriğidir\",\n" +
                "  \"userId\": 1\n" +
                "}";

        Response response = given()
                .baseUri(BASE_URL)
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post("/posts")
                .then()
                .time(lessThan(1500L), TimeUnit.MILLISECONDS)
                .statusCode(201)
                .body("title", equalTo("Test Post"))
                .body("userId", equalTo(1))
                .extract().response();

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        System.out.println("POST İstek URL: " + BASE_URL + "/posts");
        System.out.println("Gönderilen Veri: " + requestBody);
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());
        System.out.println("Çalışma Süresi: " + duration + " ms");
        System.out.println("=== POST TEST TAMAMLANDI ===\n");
    }

    @Test
    public void testGetAllPosts() {
        long startTime = System.currentTimeMillis();

        System.out.println("\n========== GET ALL POSTS TEST BAŞLADI ==========");

        Response response = given()
                .baseUri(BASE_URL)
                .when()
                .get("/posts")
                .then()
                .time(lessThan(3000L), TimeUnit.MILLISECONDS)
                .statusCode(200)
                .body("size()", greaterThan(0))
                .extract().response();

        long endTime = System.currentTimeMillis();
        long duration = response.time();

        System.out.println("GET İstek URL: " + BASE_URL + "/posts");
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Toplam Post Sayısı: " + response.jsonPath().getList("$").size());
        System.out.println("İlk Post Başlığı: " + response.jsonPath().getString("[0].title"));
        System.out.println("Çalışma Süresi: " + duration + " ms");
        System.out.println("========== GET ALL POSTS TEST TAMAMLANDI ==========\n");
    }
}