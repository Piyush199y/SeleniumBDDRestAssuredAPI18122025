package org.piyush.pojo;

public class AddressRequest {

    private String city;
    private String pincode;

    public AddressRequest(String city, String pincode) {
        this.city = city;
        this.pincode = pincode;
    }

    public String getCity() {
        return city;
    }

    public String getPincode() {
        return pincode;
    }
}
