import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class DateProcessingTest {

    @Test
    public void testDates() {
        int year = 2021;
        int month = 4;
        int day = 23;

        assertTrue(DateProcessing.parseDate("23/04/2021").equals(LocalDate.of(year, month, day)));
        assertTrue(DateProcessing.parseDate("23.04.2021").equals(LocalDate.of(year, month, day)));
        assertTrue(DateProcessing.parseDate("23-04-2021").equals(LocalDate.of(year, month, day)));
        assertTrue(DateProcessing.parseDate("23 04 2021").equals(LocalDate.of(year, month, day)));

        assertTrue(DateProcessing.parseDate("23/04/21").equals(LocalDate.of(year, month, day)));
        assertTrue(DateProcessing.parseDate("23.04.21").equals(LocalDate.of(year, month, day)));
        assertTrue(DateProcessing.parseDate("23-04-21").equals(LocalDate.of(year, month, day)));
        assertTrue(DateProcessing.parseDate("23 04 21").equals(LocalDate.of(year, month, day)));

        assertTrue(DateProcessing.parseDate("23/4/21").equals(LocalDate.of(year, month, day)));
        assertTrue(DateProcessing.parseDate("23.4.21").equals(LocalDate.of(year, month, day)));
        assertTrue(DateProcessing.parseDate("23-4-21").equals(LocalDate.of(year, month, day)));
        assertTrue(DateProcessing.parseDate("23 4 21").equals(LocalDate.of(year, month, day)));

        day = 7;
        assertTrue(DateProcessing.parseDate("7/4/21").equals(LocalDate.of(year, month, day)));
        assertTrue(DateProcessing.parseDate("7.4.21").equals(LocalDate.of(year, month, day)));
        assertTrue(DateProcessing.parseDate("7-4-21").equals(LocalDate.of(year, month, day)));
        assertTrue(DateProcessing.parseDate("7 4 21").equals(LocalDate.of(year, month, day)));




        year = 2021;
        month = 4;
        day = 23;
        int year2 = 2022;
        int month2 = 2;
        int day2 = 18;

        assertTrue(DateProcessing.parseDateRange("23/04/2021 - 18/02/2022").equals(Arrays.asList(LocalDate.of(year, month, day), LocalDate.of(year2, month2, day2))));
        assertTrue(DateProcessing.parseDateRange("23/04/2021 / 18/02/2022").equals(Arrays.asList(LocalDate.of(year, month, day), LocalDate.of(year2, month2, day2))));
        assertTrue(DateProcessing.parseDateRange("23/04/2021 to 18/02/2022").equals(Arrays.asList(LocalDate.of(year, month, day), LocalDate.of(year2, month2, day2))));
        assertTrue(DateProcessing.parseDateRange("23/04/2021 18/02/2022").equals(Arrays.asList(LocalDate.of(year, month, day), LocalDate.of(year2, month2, day2))));

    }

}