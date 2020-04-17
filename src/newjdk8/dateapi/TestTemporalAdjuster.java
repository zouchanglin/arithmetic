package newjdk8.dateapi;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class TestTemporalAdjuster {
    public static void main(String[] args) {
        // 获取下个周日
        LocalDate localDate = LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
    }
}
