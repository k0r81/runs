package korbas.runs.utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

public class DateUtils {

    public static LocalDate convertDateToLocalDate(Date dateToConvert) {
        Instant instant = Instant.ofEpochMilli(dateToConvert.getTime());

        return instant.atZone(ZoneId.systemDefault())
                .toLocalDate();
    }
}
