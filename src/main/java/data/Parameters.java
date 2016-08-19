package data;

public enum Parameters {

    SITEURL("https://mail.google.com/"),
    BROWSER("chrome");

    private String value;

    Parameters(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
