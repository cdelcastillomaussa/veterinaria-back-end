package com.softcaribbean.VeterinariaBack.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class UtilDate {

    private UtilDate(){}

    public static LocalDateTime convertToLocalDateTimeViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }


    public static LocalDate getLocalDate(java.sql.Date tmp) {
        if (tmp == null) {
            return null;
        }
        return tmp.toLocalDate();
    }
}
