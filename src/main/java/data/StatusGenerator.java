package data;

import com.github.javafaker.Faker;
import models.Status;

public class StatusGenerator {

    private Faker faker = new Faker();

    public Status generateStatus(){

        Status status = new Status();
        status.setStatus(faker.chuckNorris().fact());

        return status;
    }
}
