package tests;

import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Endpoints;

import static io.restassured.RestAssured.given;

public class CourseTest extends BaseTest {

    @Test(priority = 5)
    @Owner("Lalucia")
    @Description("Get Published Courses")
    public void getPublishedCourses() {

        Response response =

                given()
                        .queryParam("category", "All")
                        .queryParam("level", "beginner")

                        .when()
                        .get(Endpoints.PUBLISHED_COURSES)

                        .then()
                        .statusCode(200)
                        .extract()
                        .response();

        response.prettyPrint();

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(response.jsonPath().getBoolean("success"));
        Assert.assertEquals(
                response.jsonPath().getString("message"),
                "Courses retrieved successfully"
        );
    }
}