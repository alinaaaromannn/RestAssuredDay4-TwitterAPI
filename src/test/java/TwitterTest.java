import data.StatusGenerator;
import io.restassured.response.ValidatableResponse;
import models.Status;
import org.apache.http.HttpStatus;
import org.junit.Test;
import util.EnvReaderTwitter;

import static io.restassured.RestAssured.given;

public class TwitterTest {

    String consumerKey = "RpBFNwdImPANi8RMBozdfigkv";
    String consumerSecret = "XKSZ8opxiLWXis6YqG9A8BWVVyf19EbUjXGQ6f0Hoh9AiKtmX8";
    String accessToken = "1293436345994686467-fMlfTTt16VeR837bFjW3f8Gdi5qjdv";
    String tokenSecret = "aqtExKSMvnzxemKFBM1Xd1DvIwAjkAHzF72O88NLDdECI";

    @Test
    public void postStatus() {

        StatusGenerator statusGenerator = new StatusGenerator();
        Status status = statusGenerator.generateStatus();

        ValidatableResponse postStatusResponse = given()
                .baseUri(EnvReaderTwitter.getBaseUriTwitter())
                .basePath(EnvReaderTwitter.getBasePathTwitter())
                .auth()
                .oauth(consumerKey, consumerSecret, accessToken, tokenSecret)
                .queryParam("status", status)
                .log().all()
                .post("update.json")
                .prettyPeek()
                .then()
                .statusCode(HttpStatus.SC_OK);

        int id = postStatusResponse.extract().jsonPath().getInt("id");
    }

    @Test
    public void getStatus() {
        given()
                .baseUri(EnvReaderTwitter.getBaseUriTwitter())
                .basePath(EnvReaderTwitter.getBasePathTwitter())
                .auth()
                .oauth(consumerKey, consumerSecret, accessToken, tokenSecret)
                .queryParam("id", "1293483929312337922")
                .header("Content-type", "application/json")
                .when()
                .get("show.json")
                .prettyPeek()
                .then()
                .statusCode(HttpStatus.SC_OK);
    }
}
