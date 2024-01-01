package com.qacart.todo.api;

import com.qacart.todo.objects.User;
import com.qacart.todo.utils.UserUtils;
import io.restassured.http.Cookie;
import io.restassured.response.Response;
import java.util.List;
import static io.restassured.RestAssured.given;

public class RegisterApi {
    private List<Cookie> restAssuredCookies;
    private String accessToken;
    private String userId;
    private String firstName;
    public String getFirstName(){
        return this.firstName;
    }
    public String getUserID(){
        return this.userId;
    }
    public String getToken(){
        return this.accessToken;
    }

    public List<io.restassured.http.Cookie> getCookies(){
        return this.restAssuredCookies;
    }
    public void register(){
        User user = UserUtils.generateRandomUser();
        Response response =
                given()
                        .baseUri("https://qacart-todo.herokuapp.com")
                        .header("Content-Type","application/json")
                        .body(user)
                        .log().all()
                .when()
                        .post("/api/v1/users/register")
                .then()
                        .log().all()
                        .extract().response();

        if(response.statusCode()!=201){
            throw new RuntimeException("Something went wrong with the request");
        }
        restAssuredCookies = response.detailedCookies().asList();
        accessToken = response.path("access_token");
        userId = response.path("userID");
        firstName = response.path("firstName");
        System.out.println(accessToken);
    }
}
