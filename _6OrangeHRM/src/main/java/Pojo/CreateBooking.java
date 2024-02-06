package Pojo;

import java.util.ArrayList;

public class CreateBooking {

    private String firstname;
    private String lastname;
    private String additionalneeds;
    private int totalprice;
    private boolean depositpaid;
    private bookingdates bookingdates;

    private ArrayList<String> mobileNumber;



    public CreateBooking(String firstname, String lastname, String additionalneeds, int totalprice, boolean depositpaid, String checkIn, String CheckOut) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.additionalneeds = additionalneeds;
        this.totalprice = totalprice;
        this.depositpaid = depositpaid;
        this.bookingdates = new bookingdates(checkIn,CheckOut);
        this.mobileNumber= new ArrayList<>();
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAdditionalneeds() {
        return additionalneeds;
    }

    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }

    public boolean isDepositpaid() {
        return depositpaid;
    }

    public void setDepositpaid(boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    public void setMobileNumber(String... s) {
        for(int i= 0; i<s.length;i++){
            this.mobileNumber.add(s[i]);
        }

    }





}
