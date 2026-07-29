package tests;

import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.LoginResponse;
import org.testng.Assert;
import org.testng.annotations.Test;
import payloads.LoginPayload;
import utils.Endpoints;

import static io.restassured.RestAssured.given;

public class LoginTest extends BaseTest {

    @Test(priority = 1)
    @Owner("Lalucia")
    @Description("Login and retrieve authentication token")
    public void login() {

        LoginPayload payload = new LoginPayload(
                "yolandamasiza@gmail.com",
                "Masiza@1988"
        );

        Response response =
                given()
                        .contentType(ContentType.JSON)
                        .body(payload)

                        .when()
                        .post(Endpoints.LOGIN)

                        .then()
                        .extract()
                        .response();

        response.prettyPrint();

        Assert.assertEquals(response.getStatusCode(),200);

        LoginResponse loginResponse =
                response.as(LoginResponse.class);

        token = loginResponse.getData().getToken();
        System.out.println("Generated Token:");
        System.out.println(token);

        Assert.assertNotNull(token);

    }

}