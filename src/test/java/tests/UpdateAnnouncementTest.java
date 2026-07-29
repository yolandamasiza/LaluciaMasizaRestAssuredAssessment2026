package tests;

import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import payloads.AnnouncementPayload;
import utils.Endpoints;

import static io.restassured.RestAssured.given;

public class UpdateAnnouncementTest extends BaseTest {

    @Test(priority = 3)
    @Owner("Lalucia")
    @Description("Update Announcement")
    public void updateAnnouncement() {

        AnnouncementPayload payload = new AnnouncementPayload();
        payload.setTitle("Updated Title");
        payload.setContent("Updated content1");

        Response response =
                given()
                        .contentType(ContentType.JSON)
                        .header("Authorization", "Bearer " + token)
                        .pathParam("id", announcementId)
                        .body(payload)

                        .when()
                        .put(Endpoints.UPDATE_ANNOUNCEMENT)

                        .then()
                        .extract()
                        .response();

        response.prettyPrint();

        Assert.assertEquals(response.getStatusCode(), 200);

        String returnedId = response.jsonPath().getString("data.id");

        Assert.assertEquals(returnedId, announcementId);

        Assert.assertTrue(response.jsonPath().getBoolean("success"));

        Assert.assertEquals(
                response.jsonPath().getString("message"),
                "Announcement updated successfully"
        );
    }
}