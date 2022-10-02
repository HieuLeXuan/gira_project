package cybersoft.javabackend.java18.common.util;

import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @UtilityClass class chuc nang khong tao instance cua lop nay, chi co static trong class nay
 */
@UtilityClass
public class DateTimeUtils {

    /**
     * dinh dang don gian cho lam do an, demo
      */

    public static final String DATETIME_FORMAT = "dd-MM-yyyy HH:mm:ss";

    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DATETIME_FORMAT);

    public static String now() {
        return LocalDateTime.now().format(DATE_TIME_FORMATTER);
    }
}
