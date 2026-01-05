package org.piyush.pojo;

public class UserResponse {

    private String id;
    private String username;
    private int age;
    private AddressResponse address;
    private String createdAt;

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public int getAge() {
        return age;
    }

    public AddressResponse getAddress() {
        return address;
    }

    public String getCreatedAt() {
        return createdAt;
    }
}
