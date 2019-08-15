package Browny.Admin.Enum;

public enum Genre {
    B("Bachata"),
    S("Salsa"),
    H("Hiphop");
    // Key("Value");

    private String value;

    Genre(String value) {
        this.value = value;
    }

    public String getKey() {
        return name();
    }

    public String getValue() {
        return value;
    }
}