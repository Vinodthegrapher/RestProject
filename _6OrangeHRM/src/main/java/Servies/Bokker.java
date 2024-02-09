package Servies;

import static Utility.Utilities.*;

import Pojo.AuthBody;
import Pojo.CreateBooking;
import  Utility.RestMethods;
import Utility.Utilities;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Properties;
import  org.testng.Assert;

import static io.restassured.RestAssured.*;

public class Bokker {
    RestMethods rM = new RestMethods();

    public static void getBookings() throws IOException {
        RestMethods rM = new RestMethods();
        String url = readProperties("domainName", "demo") + readProperties("getBookingIds", "demo");
        HashMap<String, Object> queryParam = new HashMap<>();
        System.out.println(url);
        Response rs = rM.doGetWithQueryParam(url, queryParam);

    }

    public String generateAuthTokenforBooker() throws IOException {

        String url = readProperties("domainName", "demo") + readProperties("generateAuthToken", "demo");
        HashMap<String, Object> body = new HashMap<>();
        body.put("username", "admin");
        body.put("password", "password123");
        System.out.println(url);
        Response resp = rM.doPostWithHashMap(url, body);
        String token = (String) rM.getValuefromResponse(resp,"token");

        return token;

    }

   public String generateAuthToken() throws IOException {

        String url = readProperties("domainName", "demo") + readProperties("generateAuthToken", "demo");
        HashMap<String, Object> body = new HashMap<>();
        body.put("username", "admin");
        body.put("password", "password123");
        System.out.println(url);
        Response resp = rM.doPostWithHashMap(url, body);
        String token = (String) rM.getValuefromResponse(resp,"token");

        return token;

    }

    public void createBooking() throws IOException {
  /*      String url = readProperties("domainName","demo")+readProperties("createBooking","demo");

        HashMap<String, Object> bookingdates= new HashMap<>();
        bookingdates.put("checkin","2024-02-03");
        bookingdates.put("checkout","2024-02-14");
        HashMap<String, Object> body= new HashMap<>();
        body.put("firstname","vinod");
        body.put("lastname","jayebhaye");
        body.put("totalprice",222);
        body.put("depositpaid",true);
        body.put("additionalneeds","Breakfast");
        body.put("bookingdates",bookingdates);
        Response resp= rM.doPostWithHashMap(url,body);*/
        HashMap<String, Object> accounting1 = new HashMap<>();
        accounting1.put("firstName", "v");
        accounting1.put("lastName", "j");
        accounting1.put("age", "27");

        HashMap<String, Object> accounting2 = new HashMap<>();
        accounting2.put("firstName", "v");
        accounting2.put("lastName", "j");
        accounting2.put("age", "27");


        HashMap<String, Object> sales1 = new HashMap<>();
        sales1.put("firstName", "v");
        sales1.put("lastName", "j");
        sales1.put("age", "27");


        HashMap<String, Object> sales2 = new HashMap<>();
        sales2.put("firstName", "s");
        sales2.put("lastName", "y");
        sales2.put("age", "24");

        ArrayList<HashMap<String, Object>> accounting = new ArrayList<>();
        accounting.add(accounting1);
        accounting.add(accounting2);

        ArrayList<HashMap<String, Object>> sales = new ArrayList<>();
        sales.add(sales1);
        sales.add(sales2);

        HashMap<String, Object> body = new HashMap<>();
        body.put("accounting", accounting);
        body.put("sales", sales);

    }


    public void genAuth() throws IOException {
        String url = readProperties("domainName", "demo") + readProperties("generateAuthToken", "demo");
        AuthBody authBody= new AuthBody("admin","password123");
        rM.doPostWithPojo(url,authBody);
    }

    public void createBookingWithPojo(HashMap<String, String> testData) throws IOException {
        String url = readProperties("domainName","demo")+readProperties("updateBooking","demo");
        CreateBooking createBooking= new CreateBooking(testData.get("name"),testData.get("sname"),testData.get("depositpaid"),225,true,"2024-02-04","2024-02-14");


        String token=generateAuthToken();
        System.out.println("*****************"+token+"*************************");
        Response rs=rM.doPostWithPojoAndToken(url,createBooking,token);
        System.out.println("***************** 3rd api*************************");
        rs=rM.doGetWithToken(url+"/"+rM.getValuefromResponse(rs,"bookingid"),token);
       Assert.assertEquals(rs.statusCode(),200);
       Assert.assertEquals(rM.getValuefromResponse(rs,"firstname"),testData.get("name"));
    }


    public void updateBooking() throws IOException {
        String url = readProperties("domainName","demo")+readProperties("updateBooking","demo")+"/685";
        JSONObject updateBooking= new JSONObject();
        updateBooking.put("firstname","Vinod");
        updateBooking.put("lastname","Brown");
        updateBooking.put("totalprice",111);
        updateBooking.put("depositpaid",true);
        updateBooking.put("additionalneeds","lunch");
        JSONObject bookingdates= new JSONObject();
        bookingdates.put("checkin","2024-02-06");
        bookingdates.put("checkout","2024-02-31");
        updateBooking.put("bookingdates",bookingdates);
        String s= generateAuthTokenforBooker();
        Response rs=rM.doPutWithJson(url,updateBooking, s);
        System.out.println(rs.getStatusCode());
    }




}
