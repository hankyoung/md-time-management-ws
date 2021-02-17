package com.knb.mdtimemanagement.time;

public enum StatusEnum {
    ACTIVE("Đang hoạt động"),
    INACTIVE("Hết hiệu lực"),
    IN_PROGRESS("Đang trong quá trình thực thi");

    private final String statusName;

    StatusEnum(String statusName) {
        this.statusName = statusName;
    }

    public String getStatusName() {
        return statusName;
    }
}
