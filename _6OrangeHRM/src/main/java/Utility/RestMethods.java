package Utility;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Objects;

import static io.restassured.RestAssured.given;

public class RestMethods {
     public Response doGet(String url){

         Response rs = given().when().get(url).then().extract().response();
         rs.prettyPrint();
         return rs;
     }

    public Response doGetWithToken(String url, String token){

        Response rs = given().auth().oauth2(token).when().get(url).then().extract().response();
        rs.prettyPrint();
        return rs;
    }

    public Response doGetWithQueryParamAndToken(String url, HashMap<String, Object> parameters, String token){

        Response rs = given().formParams(parameters).auth().oauth2(token).when().get(url).then().extract().response();
        rs.prettyPrint();
        return rs;
    }

    public Response doGetWithQueryParam(String url, HashMap<String, Object> parameters){

        Response rs = given().formParams(parameters).when().get(url).then().extract().response();
        rs.prettyPrint();
        return rs;
    }

    public Response doPost(String url, String payload){

        Response rs = given().body(payload).when().post(url).then().extract().response();
        rs.prettyPrint();
        return rs;
        //
    }

    public Response doPostWithHashMap(String url, HashMap<String, Object> payload){

        Response rs = given().body(payload).contentType("application/json").when().post(url).then().extract().response();
        rs.prettyPrint();
        return rs;
    }

    public Response doPostWithPojo(String url, Object payload){

        Response rs = given().body(payload).contentType("application/json").when().post(url).then().extract().response();
        rs.prettyPrint();
        return rs;
    }

    public Response doPostWithPojoAndToken(String url, Object payload, String token){

        Response rs = given().body(payload).auth().oauth2(token).contentType("application/json").when().post(url).then().extract().response();
        rs.prettyPrint();
        return rs;
    }

    public Object getValuefromResponse(Response response, String path){
        JsonPath jsonPath=response.jsonPath();
        Object value=jsonPath.get(path);
        return value;
    }
}
