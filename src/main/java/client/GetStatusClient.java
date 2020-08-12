package client;

import org.apache.http.HttpStatus;
import util.EnvReaderTwitter;

import javax.xml.ws.Response;

import static io.restassured.RestAssured.given;

public class GetStatusClient {

    public Response getStatusById() {
        return (Response) given()
                .baseUri(EnvReaderTwitter.getBaseUriTwitter())
                .basePath(EnvReaderTwitter.getBasePathTwitter())
                .auth()
                .oauth(EnvReaderTwitter.getConsumerKey(), EnvReaderTwitter.getConsumerSecret(), EnvReaderTwitter.getAccessToken(), EnvReaderTwitter.getTokenSecret())
                .queryParam("id", "1293483929312337922")
                .header("Content-type", "application/json")
                .when()
                .get("show.json")
                .prettyPeek()
                .then()
                .statusCode(HttpStatus.SC_OK);
    }
}

