package org.piyush.pojo;

public class UserRequest {

    private String username;
    private int age;
    private AddressRequest address;

    public UserRequest(String username, int age, AddressRequest address) {
        this.username = username;
        this.age = age;
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public int getAge() {
        return age;
    }

    public AddressRequest getAddress() {
        return address;
    }
}
