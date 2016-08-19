package data;

public enum UserCredentials {

    USER1("TestUserJonh@gmail.com"),
    USER2("TestUserRuss@gmail.com"),
    PASSWORD("password12345678");

    private String value;

    UserCredentials(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }


}
