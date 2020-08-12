package client;

import data.StatusGenerator;
import models.Status;
import org.apache.http.HttpStatus;
import util.EnvReaderTwitter;

import javax.xml.ws.Response;

import static io.restassured.RestAssured.given;

public class PostStatusClient {

    StatusGenerator statusGenerator = new StatusGenerator();
    Status status = statusGenerator.generateStatus();

    public Response createStatus() {
        return (Response) given()
                .baseUri(EnvReaderTwitter.getBaseUriTwitter())
                .basePath(EnvReaderTwitter.getBasePathTwitter())
                .auth()
                .oauth(EnvReaderTwitter.getConsumerKey(), EnvReaderTwitter.getConsumerSecret(), EnvReaderTwitter.getAccessToken(), EnvReaderTwitter.getTokenSecret())
                .queryParam("status", status)
                .log().all()
                .post("update.json")
                .prettyPeek()
                .then()
                .statusCode(HttpStatus.SC_OK);
    }
}
