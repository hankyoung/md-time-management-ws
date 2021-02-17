package com.knb.mdtimemanagement.common;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class MessageServiceImpl implements MessageService {
    private final MessageSource messageSource;

    public MessageServiceImpl(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    public String getMessage(String code, Object[] objects, Locale locale) {
        return messageSource.getMessage(code, objects, locale);
    }

    @Override
    public String getMessage(String code, Locale locale) {
        return getMessage(code, null, locale);
    }

    @Override
    public String getMessage(String code) {
        Locale locale = LocaleContextHolder.getLocale();
        return getMessage(code, null, locale);
    }
}
