package Services;


import Servies.Bokker;
import Utility.Utilities;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;


public class booker {
    Bokker bk= new Bokker();
    @Test(dataProviderClass = Utilities.class,dataProvider = "testData")
    public void createBooking(HashMap<String ,String> testData) throws InterruptedException, IOException {
       System.out.println(testData);
        System.out.println(testData.get("name"));
       bk.createBookingWithPojo( testData);
    }
}
