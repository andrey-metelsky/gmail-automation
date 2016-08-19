package data;

import static utils.utils.getRandomString;

public enum MessageValues {

    SUBJECT(getRandomString(10));


    private String value;

    MessageValues(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
