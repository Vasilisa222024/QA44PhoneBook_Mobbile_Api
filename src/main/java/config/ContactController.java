package config;

import dto.ContactDtoLombok;
import dto.TokenDto;
import dto.UserDtoLombok;
import interfaces.BaseApi;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeSuite;

import static helper.PropertiesReader.getProperty;
import static io.restassured.RestAssured.given;

public class ContactController implements BaseApi {
     protected TokenDto tokenDto;
    @BeforeSuite
    public  void login() {

        UserDtoLombok user = UserDtoLombok.builder()
                .username(getProperty("data.properties", "email"))
                .password(getProperty("data.properties", "password"))
                .build();
        // System.out.println(requestRegLogin(user,LOGIN_PATH).getStatusCode());
        Response response = given()
                .body(user)
                .contentType(ContentType.JSON)
                .when()
                .post(BASE_URL + LOGIN_PATH)
                .thenReturn();
        // TokenDto tokenDto=response.as(TokenDto.class);
        if (response.getStatusCode() == 200) {
            tokenDto = response.as(TokenDto.class);
        } else {
            System.out.println("Something went wrong, status code -->"+response.getStatusCode());
        }
    }
    protected  Response getUserContactsResponse(String token){
        return  given()
                .header("Authorization",token)
                .when()
                .get(BASE_URL+GET_ALL_CONTACTS_PATH)
                .thenReturn();

    }

    protected Response updateContactResponseWithToken(ContactDtoLombok contact){
        return given()
                .body(contact)
                .header("Authorization", tokenDto.getToken())
                .contentType(ContentType.JSON)
                //.spec(requestSpecWithToken)
                .put(BASE_URL+GET_ALL_CONTACTS_PATH)
                .thenReturn();
    }
    protected Response updateContactResponse(ContactDtoLombok contact, String token){
        return given()
                .body(contact)
                .header("Authorization", token)
                .contentType(ContentType.JSON)
                //.spec(requestSpecWithToken)
                .put(BASE_URL+GET_ALL_CONTACTS_PATH)
                .thenReturn();
    }
}
