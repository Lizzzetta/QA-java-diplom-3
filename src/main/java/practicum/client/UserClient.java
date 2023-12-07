package practicum.client;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import practicum.pojo.*;

import static io.restassured.RestAssured.given;

public class UserClient
{
    private static final String AUTH_REGISTER_PATH = "/auth/register";
    private static final String AUTH_LOGIN_PATH = "/auth/login";
    private static final String AUTH_USER_PATH = "/auth/user";

    public UserClient(String baseURI)
    {
        RestAssured.baseURI = baseURI;
    }

    @Step("Register test user by rest api")
    public void registerUser(String email, String password, String name)
    {
        given()
                .when()
                .contentType(ContentType.JSON)
                .body(new RegisterUserParameters(email, password, name))
                .post(AUTH_REGISTER_PATH)
                .then()
                .statusCode(200);
    }

    @Step("Check user registered by rest api")
    public void checkUserRegistered(String email, String password)
    {
        given()
                .when()
                .contentType(ContentType.JSON)
                .body(new LoginUserParameters(email, password))
                .post(AUTH_LOGIN_PATH)
                .then()
                .statusCode(200);
    }

    @Step("Remove test user by rest api")
    public void deleteUser(String email, String password)
    {
        UserLoginResponse courierLoginResponse = given()
                .when()
                .contentType(ContentType.JSON)
                .body(new LoginUserParameters(email, password))
                .post(AUTH_LOGIN_PATH)
                .thenReturn()
                .as(UserLoginResponse.class);

        given()
                .when()
                .header("Authorization", courierLoginResponse.getAccessToken())
                .delete(AUTH_USER_PATH)
                .then()
                .statusCode(202);
    }
}
