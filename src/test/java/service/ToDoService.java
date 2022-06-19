package service;

import io.restassured.RestAssured;

public class ToDoService {

    public static int validateResponseStatus(String path) {
        return RestAssured.given().get(path).getStatusCode();
    }

}
