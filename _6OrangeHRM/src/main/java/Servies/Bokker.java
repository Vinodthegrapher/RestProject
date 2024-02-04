package Servies;

import static Utility.Utilities.*;

import Pojo.AuthBody;
import Pojo.CreateBooking;
import  Utility.RestMethods;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Properties;

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

    public String generateAuthToken() throws IOException {
        String token = "";
        String url = readProperties("domainName", "demo") + readProperties("generateAuthToken", "demo");
        HashMap<String, Object> body = new HashMap<>();
        body.put("username", "admin");
        body.put("password", "password123");
        System.out.println(url);
        Response resp = rM.doPostWithHashMap(url, body);
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

        JSONObject accounting1j = new JSONObject();
        accounting1j.put("firstName", "radha");
        accounting1j.put("lastName", "roshan");
        accounting1j.put("age", 24);

        JSONObject accounting2j = new JSONObject();
        accounting2j.put("firstName", "radha1");
        accounting2j.put("lastName", "roshan1");
        accounting2j.put("age", 24);

        JSONArray accountingj = new JSONArray();
        accountingj.put(accounting1j);
        accountingj.put(accounting2j);

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
        body.put("accounting", accountingj);
        body.put("sales", sales);

    }


    public void genAuth() throws IOException {
        String url = readProperties("domainName", "demo") + readProperties("generateAuthToken", "demo");
        AuthBody authBody= new AuthBody("admin","password123");
        rM.doPostWithPojo(url,authBody);
    }

    public void createBookingWithPojo() throws IOException {
        String url = readProperties("domainName","demo")+readProperties("createBooking","demo");
        CreateBooking createBooking= new CreateBooking("Karan","Singh","lunch",225,true,"2024-02-04","2024-02-14");
        rM.doPostWithPojo(url,createBooking);
    }




























    public void studentNames(String s, int... i){
        System.out.println(i.length);
        for(int j =0; j < i.length ; j++){
            System.out.println(i[j]);
        }
    }

    public static void main(String[] args) throws IOException {
        Bokker bK= new Bokker();
       bK.createBookingWithPojo();

    }
}
