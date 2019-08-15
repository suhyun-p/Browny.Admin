package Browny.Admin.Enum;

public enum ClassType {
    N("일반"), // Normal
    P("공연반"), // Performance
    C("클리닉"), // Clinic
    W("워크샵"), // Workshop
    T("트레이닝"), // Workshop
    O("Open강습"); // Open 강습
    // Key("Value");

    private String value;

    ClassType(String value) {
        this.value = value;
    }

    public String getKey() {
        return name();
    }

    public String getValue() {
        return value;
    }
}