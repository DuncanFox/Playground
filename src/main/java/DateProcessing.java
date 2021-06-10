import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateProcessing {
    private static final String SINGLE_DATE = "(\\d{1,2})[ -./]*(\\d{1,2})[ -./]*(\\d{2,4})";
    private static final String RANGE_SEPARATOR = "\\s*(?:[-/]*|to)\\s*";

    private static final Pattern PATTERN = Pattern.compile(SINGLE_DATE);
    public static LocalDate parseDate(String range) {
        Matcher matcher = PATTERN.matcher(range);
        if (matcher.matches()) {
            int day = Integer.parseInt(matcher.group(1));
            int month = Integer.parseInt(matcher.group(2));
            int year = Integer.parseInt(matcher.group(3));
            if (year < 100) {
                year += 2000;
            }
            return LocalDate.of(year, month, day);
        }

        return null;
    }

    private static final Pattern RANGE_PATTERN = Pattern.compile(SINGLE_DATE + RANGE_SEPARATOR + SINGLE_DATE);
    public static List<LocalDate> parseDateRange(String range) {
        Matcher matcher = RANGE_PATTERN.matcher(range);
        if (matcher.matches()) {
            List<LocalDate> rangeDates = new ArrayList<>();
            int day = Integer.parseInt(matcher.group(1));
            int month = Integer.parseInt(matcher.group(2));
            int year = Integer.parseInt(matcher.group(3));
            if (year < 100) {
                year += 2000;
            }
            LocalDate startDate = LocalDate.of(year, month, day);
            rangeDates.add(startDate);

            day = Integer.parseInt(matcher.group(4));
            month = Integer.parseInt(matcher.group(5));
            year = Integer.parseInt(matcher.group(6));
            if (year < 100) {
                year += 2000;
            }
            LocalDate endDate = LocalDate.of(year, month, day);
            rangeDates.add(endDate);
            return rangeDates;
        }

        return null;
    }
}
