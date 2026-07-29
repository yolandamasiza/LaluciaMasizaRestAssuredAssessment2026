package base;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    public static String token;
    public static String announcementId;

    @BeforeSuite
    public void setup() {

        RestAssured.baseURI = "https://www.ndosiautomation.co.za/APIDEV";

    }

}