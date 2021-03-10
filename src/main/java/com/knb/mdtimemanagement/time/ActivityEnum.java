package com.knb.mdtimemanagement.time;

public enum ActivityEnum {
    EAT("Uyn Uyn ăn"),
    SLEEP("Uyn Uyn ngủ"),
    BATH("Uyn Uyn đi bơi"),
    POO("Fighting ị ị"),
    WAKE("Uyn Uyn dậy");

    private final String activityDesc;

    ActivityEnum(String activityDesc) {
        this.activityDesc = activityDesc;
    }

    public String getActivityDesc() {
        return activityDesc;
    }

    public static ActivityEnum getEnum(String value) {
        for (ActivityEnum v : values())
            if (v.name().equalsIgnoreCase(value)) return v;
        throw new IllegalArgumentException();
    }
}
