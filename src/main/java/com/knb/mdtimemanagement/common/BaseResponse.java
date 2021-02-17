package com.knb.mdtimemanagement.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse {
    private Boolean isSuccess;
    private String message;
    private String errorCode;
    private Object data;

    public void setAllParams(Boolean isSuccess, String message, String errorCode, Object data) {
        this.isSuccess = isSuccess;
        this.message = message;
        this.errorCode = errorCode;
        this.data = data;
    }
}
