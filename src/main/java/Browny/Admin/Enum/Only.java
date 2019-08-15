package Browny.Admin.Enum;

public enum Only {
    M("MensOnly"),
    F("LadyOnly");
    // Key("Value");

    private String value;

    Only(String value) {
        this.value = value;
    }

    public String getKey() {
        return name();
    }

    public String getValue() {
        return value;
    }
}