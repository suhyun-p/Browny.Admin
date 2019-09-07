package Browny.Admin.Enum;

public enum ClassType {
    P("공연반"), // Performance
    C("클리닉"), // Clinic
    W("워크샵"), // Workshop
    T("트레이닝"), // Workshop
    O("Open강습"), // Open 강습
    H("한곡완성반"),
    L1("초급반"),
    L2("초중급반"),
    L3("준중급반"),
    L4("중급반");
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