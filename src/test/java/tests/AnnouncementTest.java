package tests;

import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.AnnouncementResponse;
import org.testng.Assert;
import org.testng.annotations.Test;
import payloads.AnnouncementPayload;
import utils.Endpoints;

import static io.restassured.RestAssured.given;

public class AnnouncementTest extends BaseTest {

    @Test(priority = 2)
    @Owner("Lalucia")
    @Description("Create Announcement")
    public void createAnnouncement() {

        AnnouncementPayload payload =
                new AnnouncementPayload(
                        "Important Update",
                        "This is the announcement content"
                );
        System.out.println("Token = " + token);

        Response response =

                given()
                        .contentType(ContentType.JSON)
                        .header("Authorization", "Bearer " + token)
                        .body(payload)

                        .when()
                        .post(Endpoints.CREATE_ANNOUNCEMENT)

                        .then()
                        .statusCode(201)
                        .extract()
                        .response();

        AnnouncementResponse announcement =
                response.as(AnnouncementResponse.class);

        announcementId = announcement.getData().getId();

        System.out.println("Announcement ID : " + announcementId);

        Assert.assertTrue(announcement.isSuccess());
        Assert.assertEquals(
                announcement.getMessage(),
                "Announcement created successfully"
        );

        Assert.assertEquals(
                announcement.getData().getTitle(),
                "Important Update"
        );
    }
}