package tests;

import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Endpoints;

import static io.restassured.RestAssured.given;

public class DeleteAnnouncementTest extends BaseTest {

    @Test(priority = 4)
    @Owner("Lalucia")
    @Description("Delete Announcement")
    public void deleteAnnouncement() {

        Response response =
                given()
                        .header("Authorization", "Bearer " + token)
                        .pathParam("id", announcementId)

                        .when()
                        .delete(Endpoints.DELETE_ANNOUNCEMENT)

                        .then()
                        .statusCode(200)
                        .extract()
                        .response();

        response.prettyPrint();

        Assert.assertEquals(response.getStatusCode(), 200);
    }
}