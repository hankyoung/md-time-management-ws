package com.knb.mdtimemanagement.common;

import java.util.Locale;

public interface MessageService {
    String getMessage(String code, Object[] objects, Locale locale);

    String getMessage(String code, Locale locale);

    String getMessage(String code);
}
