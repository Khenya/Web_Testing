package api.factory;

import io.restassured.response.Response;
import api.config.Configuration;

import static io.restassured.RestAssured.given;

public class RequestTOKEN {

    private static RequestTOKEN requestTOKEN;
    private String token;

    private RequestTOKEN(){
        Response response=given()
                .auth()
                .preemptive()
                .basic(Configuration.user, Configuration.password)
                .log()
                .all().
                when()
                .get(Configuration.authenticationToken);

        token = response.then().extract().path("TokenString");
    }

    public static RequestTOKEN getInstance(){
        if(requestTOKEN==null){
            requestTOKEN=new RequestTOKEN();
        }
        return requestTOKEN;
    }

    public String getToken() {
        return token;
    }
}